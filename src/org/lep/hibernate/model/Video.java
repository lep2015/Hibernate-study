package org.lep.hibernate.model;

/**
 * Created by lvep on 2016/3/15.
 */
public class Video {
    private long id;
    private String name ;
    private String url;

    // 测试如果没有一个默认无参的构造函数会怎么样
    // 结果：Hibernate的model必须一个默认无参的构造函数以便Hibernate使用reflect创建对象
    // 但是普通的java类可以不显式声明一个无参构造函数，JVM在运行时会自动分配一个
    // ?:那为什么Hibernate不能使用JVM动态创建的无参构造函数？是因为无法访问？还是。。。。
    public Video() {
        this.id = id;
    }
    public Video(long id) {
        this.id = id;
    }

    /**
     * get和set方法是建议的，但不是必须的
     * @return
     */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
