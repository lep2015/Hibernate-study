package org.lep.hibernate.test;

import junit.framework.TestCase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.ImprovedNamingStrategy;
import org.junit.Test;
import org.lep.hibernate.model.Video;

import java.util.List;

/**
 * Created by lvep on 2016/3/15.
 */
public class TestApi extends TestCase {
    private SessionFactory sessionFactory;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        // 初始化sessionFactory，由于Hibernate配置文件放在了classpath下，所以不用指定配置文件位置
        sessionFactory = new Configuration().setNamingStrategy(ImprovedNamingStrategy.INSTANCE).configure().buildSessionFactory();

    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
        if(sessionFactory != null){
            sessionFactory.close();
        }
    }

    @Test
    public void testBasicUsage(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Video v1 = new Video();
        v1.setName("1.avi");
        v1.setUrl("http://200007041.vod.myqcloud.com/200007041_3fe5e304ea5311e59289eb529c79e6bd.f20.mp4");
        session.save(v1);
        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();
        session.beginTransaction();
        List videos = session.createQuery("from Video").list();
        for(Video v : (List<Video>)videos){
            System.out.println(v);
        }
        session.getTransaction().commit();
        session.close();

    }
}
