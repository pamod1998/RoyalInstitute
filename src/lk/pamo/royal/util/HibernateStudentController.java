package lk.pamo.royal.util;


import lk.pamo.royal.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateStudentController {

    public void saveStudent(Student s) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(s);
            tx.commit();
            session.close();
        }

    }

    public List<Student> getAllStudents() {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Student> list = session.createNativeQuery("SELECT * FROM student", Student.class).list();


        transaction.commit();
        return list;

    }

}
