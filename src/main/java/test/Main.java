package test;

import org.hibernate.Session;
import test.entity.Department;
import test.util.HibernateUtil;

/**
 * Created by  on 13.04.16.
 */
public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        Department dep = new Department();

        dep.setName("gex");
        session.save(dep);
        session.getTransaction().commit();

    }
}
