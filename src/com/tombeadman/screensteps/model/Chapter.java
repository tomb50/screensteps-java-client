package com.tombeadman.screensteps.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tombeadman
 * Date: 22/11/14
 * Time: 15:07
 */
@XStreamAlias("chapter")
public class Chapter implements Serializable{
    private String title;
    private String id;
    private Integer position;
    private String url;


    private List<Lesson> lessons;

    public String getTitle() {
        return title;
    }

    public String getId() {
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
