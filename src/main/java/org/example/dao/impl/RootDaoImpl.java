package org.example.dao.impl;

import org.example.dao.RootDao;
import org.example.exception.DataProcessingException;
import org.example.model.Root;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RootDaoImpl implements RootDao {
    @Override
    public Root add(Root root) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(root);
            transaction.commit();
            return root;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert root: " + root, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
