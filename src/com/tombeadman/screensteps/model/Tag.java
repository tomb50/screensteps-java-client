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
    private Integer count;
    private String url;

    public String getName() {
        return name;
    }

    public Integer getCount() {
        return count;
    }

    public String getUrl() {
        return url;
    }
}
