package com.tombeadman.screensteps.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tombeadman
 * Date: 22/11/14
 * Time: 20:31
 */
@XStreamAlias("lessons")
public class Lessons implements Serializable{

    @XStreamImplicit
    private List<Lesson> lesson;
    public List<Lesson> getLessons() {
        return lesson;
    }
}
