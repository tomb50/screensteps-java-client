package com.tombeadman.screensteps.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 29/11/14 Time: 13:40
 */

@XStreamAlias("media")
public class Media {
    private String type;
    private String id;
    @XStreamAlias("full_size_id")
    private String fullSizeId;
    private String filename;
    @XStreamAlias("full_size_url")
    private String fullSizeUrl;
    private String url;
    @XStreamAlias("full_size_width")
    private int fullSizeWidth;
    @XStreamAlias("full_size_height")
    private int fullSizeHeight;
    private int width;
    private int height;
    @XStreamAlias("alt_text")
    private String altText;

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public String getFullSizeId() {
        return fullSizeId;
    }

    public String getFilename() {
        return filename;
    }

    public String getFullSizeUrl() {
        return fullSizeUrl;
    }

    public String getUrl() {
        return url;
    }

    public int getFullSizeWidth() {
        return fullSizeWidth;
    }

    public int getFullSizeHeight() {
        return fullSizeHeight;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getAltText() {
        return altText;
    }
}
