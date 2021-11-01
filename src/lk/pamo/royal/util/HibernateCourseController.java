package lk.pamo.royal.util;

import lk.pamo.royal.entity.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateCourseController {


    public void saveCourse(Course c) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(c);

        transaction.commit();
        session.close();

    }

    public  List<Course> getAllCourse() {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Course> list = session.createNativeQuery("SELECT * FROM course", Course.class).list();


        transaction.commit();
        return list;

    }
}
