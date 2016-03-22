package org.lep.hibernate.test;

import junit.framework.TestCase;
import org.junit.Test;
import org.lep.hibernate.dao.VideoDao;
import org.lep.hibernate.model.Video;
import org.lep.hibernate.util.HibernateUtil;

import java.util.List;

/**
 * Created by lvep on 2016/3/20.
 */
public class TestCrud extends TestCase {
    private VideoDao dao;
    @Override
    public void setUp() throws Exception {
        dao = new VideoDao();
    }
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
        HibernateUtil.closeSessionFactory();
        dao = null;
    }
    @Test
    public void test(){
        // 测试添加
        String name = "1.avi";
        Video v1 = new Video();
        v1.setName(name);
        v1.setUrl("http://200007041.vod.myqcloud.com/2009c79e6bd.f20.mp4");
        dao.save(v1);

        // 测试查询一个
        Video video = dao.findById(1);
        System.out.println(video);
        assertEquals(video.getName(), name);

        // 测试查询多个
        List<Video> list = dao.findAll();
        for(Video v : list){
            System.out.println(v.toString());
        }
        assertEquals(list.size(), 1);

        // 测试修改
        String newName = "2.avi";
        video.setName(newName);
        dao.update(video);
        Video newVideo = dao.findById(1);
        System.out.println(newVideo);
        assertEquals(video.getName(), newVideo.getName());
    }

}
