package com.tombeadman.screensteps.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created with IntelliJ IDEA.
 * User: tombeadman
 * Date: 22/11/14
 * Time: 15:07
 */
@XStreamAlias("tag")
public class Tag {

    private String name;

    public String getName() {
        return name;
    }
}
