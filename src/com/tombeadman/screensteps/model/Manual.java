package com.tombeadman.screensteps.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tombeadman
 * Date: 22/11/14
 * Time: 15:03
 */

@XStreamAlias("manual")
public class Manual implements Serializable{
    private Space space;
    private String title;
    private String id;
    private String message;
    private List<Chapter> chapters;
    private List<Tag> tags;
    @XStreamAlias("private")
    private Boolean _private;
    private String url;
    @XStreamAlias("previous_lesson")
    private Lesson previousLesson;
    @XStreamAlias("next_lesson")
    private Lesson nextLesson;

    public Space getSpace() {
        return space;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public Boolean get_private() {
        return _private;
    }

    public String getUrl() {
        return url;
    }

    public Lesson getPreviousLesson() {
        return previousLesson;
    }

    public Lesson getNextLesson() {
        return nextLesson;
    }

    @Override
    public String toString() {
        return "Manual{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", space=" + space +
                '}';
    }
}
