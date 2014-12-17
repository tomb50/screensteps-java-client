package com.tombeadman.screensteps.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.io.Serializable;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: tombeadman
 * Date: 20/11/14
 * Time: 23:10
 */

@XStreamAlias("spaces")
public class Spaces implements Serializable{
    @XStreamImplicit
    private List<Space> space;
    public List<Space> getSpaces() {
        return space;
    }

}
