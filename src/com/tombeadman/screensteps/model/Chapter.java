package com.tombeadman.screensteps.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tombeadman
 * Date: 22/11/14
 * Time: 15:07
 */
@XStreamAlias("chapter")
public class Chapter {
    private String title;
    private Integer id;
    private Integer position;
    private String url;


    private List<Lesson> lessons;

    public String getTitle() {
        return title;
    }

    public Integer getId() {
        return id;
    }

    public Integer getPosition() {
        return position;
    }

    public String getUrl() {
        return url;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "title='" + title + '\'' +
                ", id=" + id +
                '}';
    }
}
