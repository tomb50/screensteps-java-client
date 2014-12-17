package com.tombeadman.screensteps.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: tombeadman
 * Date: 22/11/14
 * Time: 19:03
 */
@XStreamAlias("step")
public class Step implements Serializable{
    private String title;
    private String instructions;
    @XStreamAlias("instructions_position")
    private String instructionsPosition;
    private String id;
    @XStreamAlias("anchor_name")
    private String anchorName;
    @XStreamAlias("parent_id")
    private String parentId;
    private String level;
    private Media media;

    public String getTitle() {
        return title;
    }

    public String getInstructions() {
        return instructions;
    }

    public String getInstructionsPosition() {
        return instructionsPosition;
    }

    public String getId() {
        return id;
    }

    public String getAnchorName() {
        return anchorName;
    }

    public String getParentId() {
        return parentId;
    }

    public String getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "Step{" +
                "id=" + id + '\'' +
                "title='" + title + '\'' +
                '}';
    }
}
