package com.tombeadman.screensteps.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: tombeadman
 * Date: 22/11/14
 * Time: 19:21
 */
@XStreamAlias("asset")
public class Asset implements Serializable{
    private String title;
    private String id;
    private String type; //todo enumerate
    @XStreamAlias("asset_type")
    private String assetType; //todo enumerate
    private Boolean hidden;
    private String content;
    private String url;

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getAssetType() {
        return assetType;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public String getContent() {
        return content;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Asset{" +
                "title='" + title + '\'' +
                ", id=" + id +
                ", type='" + type + '\'' +
                ", assetType='" + assetType + '\'' +
                '}';
    }
}
