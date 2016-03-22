package org.lep.hibernate.test;

import junit.framework.TestCase;
import org.hibernate.Session;
import org.lep.hibernate.util.HibernateUtil;

/**
 * Created by lvep on 2016/3/21.
 */
public class BaseTest extends TestCase {
    public Session session;
    @Override
    public void setUp() throws Exception {
        session = HibernateUtil.getSession();
    }
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
        HibernateUtil.closeSessionFactory();
    }
}
