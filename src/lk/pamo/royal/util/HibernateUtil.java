package lk.pamo.royal.util;

import lk.pamo.royal.entity.Course;
import lk.pamo.royal.entity.Registration;
import lk.pamo.royal.entity.Student;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory(){
//        01

            StandardServiceRegistry sReg = new StandardServiceRegistryBuilder().loadProperties("lk/pamo/royal/application.properties").build();

//        02
            Metadata mData = new MetadataSources(sReg)
                    .addAnnotatedClass(Student.class)
                    .addAnnotatedClass(Course.class)
                    .addAnnotatedClass(Registration.class)
                    .getMetadataBuilder()
                    .build();

//        03
            return mData.getSessionFactoryBuilder().build();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

