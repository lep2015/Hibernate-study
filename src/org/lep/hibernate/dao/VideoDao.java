package org.lep.hibernate.dao;

import org.hibernate.Session;
import org.lep.hibernate.model.Video;
import org.lep.hibernate.util.HibernateUtil;

import java.util.List;

/**
 * Created by lvep on 2016/3/20.
 */
public class VideoDao {
    /**
     * 保存一个video对象
     * @param video
     */
    public void save(Video video){
        Session session = null;
        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();
            session.save(video);
//        session.persist(video);
//        session.saveOrUpdate(video);
            session.getTransaction().commit();
        } finally {
            if(session != null){
                session.close();
            }
        }
    }

    /**
     * 删除一个video
     * @param video
     */
    public void delete(Video video){
        Session session = null;
        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();
            session.delete(video);
            session.getTransaction().commit();
        } finally {
            if(session != null){
                session.close();
            }
        }
    }

    /**
     * 更新一个video
     * @param video
     */
    public void update(Video video){
        Session session = null;
        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();
            session.update(video);
//          session.saveOrUpdate(video);
            session.getTransaction().commit();
        } finally {
            if(session != null){
                session.close();
            }
        }
    }

    /**
     * 查询所有的video
     * 注意hql是一种面向对象的查询语句，也就是说查询的是对象也不是数据库中的表
     * @return 返回所有的video对象
     */
    public List<Video> findAll(){
        Session session = null;
        try{
            session = HibernateUtil.getSession();
            String hql = "from Video";
            org.hibernate.Query query = session.createQuery(hql);
            return (List<Video>)query.list();
        } finally {
            if(session != null){
                session.close();
            }
        }
    }

    /**
     * 根据id查找video
     * @param id
     * @return
     */
    public Video findById(long id){
        Session session = null;
        try{
            session = HibernateUtil.getSession();

//          session.get(Video.class, id);
//          session.load(Video.class, id);    // 使用load会有懒加载的问题

//          Criteria criteria = session.createCriteria(Video.class);
//          criteria.add(Restrictions.eq("id", id));
//          Video video = (Video)criteria.uniqueResult();

            String hql = "from Video where id=:id";
            org.hibernate.Query query = session.createQuery(hql);
            query.setLong("id", id);
            return (Video)query.uniqueResult();
        } finally {
            if(session != null){
                session.close();
            }
        }
    }




}
