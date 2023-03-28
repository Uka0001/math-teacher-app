package org.example.dao.impl;

import java.util.List;
import org.example.dao.EquationDao;
import org.example.exception.DataProcessingException;
import org.example.model.Equation;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class EquationDaoImpl implements EquationDao {
    @Override
    public Equation add(Equation equation) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(equation);
            transaction.commit();
            return equation;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert equation: " + equation, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Equation update(Equation equation) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(equation);
            transaction.commit();
            return equation;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert equation: " + equation, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<String> getEquationsByRoot(Long rootValue) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Query<String> query = session.createQuery(
                    "SELECT e.equationValue"
                            + " FROM Equation e "
                            + "JOIN Root r ON e.id = r.equationId "
                            + "WHERE r.rootValue = :rootValue", String.class);
            query.setParameter("rootValue", rootValue);
            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Couldn't find available equation by root value: "
                    + rootValue, e);
        }
    }

    @Override
    public List<String> getEquationsByNumberOfRoot(int number) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Query<String> query = session.createQuery(
                    "SELECT e.equationValue"
                            + " FROM Equation e "
                            + "JOIN Root r ON e.id = r.equationId "
                            + "WHERE size(e.rootList) = :number", String.class);
            query.setParameter("number", number);
            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Couldn't find available equation by roots number: "
                    + number, e);
        }
    }
}
