package tomb.springtest.screenstepsservice.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.List;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 20/11/14 Time: 20:27
 */


@XStreamAlias("space")
public class Space {
    private String id;
    private String title;
    private String permalink;
    private String message;
    private String description;
    @XStreamAlias("protected")
    private Boolean _protected;
    private List<Asset> assets;
    private String url;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Boolean get_protected() {
        return _protected;
    }

    public String getUrl() {
        return url;
    }

    public String getPermalink() {
        return permalink;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }

    public List<Asset> getAssets() {
        return assets;
    }
}
