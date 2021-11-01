package lk.pamo.royal.util;

import lk.pamo.royal.entity.Course;
import lk.pamo.royal.entity.Registration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateRegController {

    public List loadCid() {

//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//
//
//        List list = session.createNativeQuery("select code from course ").list();
//
//        transaction.commit();
//
//        return list;
        return null;
    }

    public List loadSid() {

//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//
//
//        List list = session.createNativeQuery("select id from student ").list();
//
//        transaction.commit();
//
//        return list;
        return null;
    }

    public void saveRegistrations(Registration r) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(r);

        transaction.commit();
    }

    public void registretion(Registration r, String course) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Course course1 = session.get(Course.class, course);
        r.setCourse(course1);
        session.save(r);


        transaction.commit();
        session.close();
    }
}
