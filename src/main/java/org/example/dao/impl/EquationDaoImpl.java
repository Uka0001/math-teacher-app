package org.example.dao.impl;

import org.example.dao.EquationDao;
import org.example.exception.DataProcessingException;
import org.example.model.Equation;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
}
