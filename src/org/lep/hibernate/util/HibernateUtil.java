package org.lep.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by lvep on 2016/3/20.
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;

    // 不允许new，保证只有一个sessionFactory
    private HibernateUtil(){}

    static {
        Configuration cfg = new Configuration();
        cfg.configure();
        sessionFactory = cfg.buildSessionFactory();
    }

    public static Session getSession(){
        return  sessionFactory.openSession();
    }

    public static void closeSessionFactory(){
        if(sessionFactory != null){
            sessionFactory.close();
        }
    }
}
