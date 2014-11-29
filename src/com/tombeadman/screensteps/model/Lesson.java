package com.tombeadman.screensteps.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tombeadman
 * Date: 22/11/14
 * Time: 17:02
 */
@XStreamAlias("lesson")
public class Lesson {

    private Space space;
    private Chapter chapter;
    private Manual manual;
    private String id;
    private String title;
    private String url;
    private String description;
    @XStreamAlias("allow_comments")
    private Boolean allowComments;
    private List<Step> steps;
    private List<Tag> tags;
    private List<Comment> comments;
    private Asset asset;


    public Space getSpace() {
        return space;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public Manual getManual() {
        return manual;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public Boolean getAllowComments() {
        return allowComments;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public Asset getAsset() {
        return asset;
    }



  @Override
    public String toString() {
        return "Lesson{" +
                "title='" + title + '\'' +
                ", id=" + id +
                '}';
    }
}
