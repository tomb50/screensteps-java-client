package tomb.springtest.screenstepsservice.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created with IntelliJ IDEA.
 * User: tombeadman
 * Date: 22/11/14
 * Time: 19:03
 */
@XStreamAlias("step")
public class Step {
    private String title;
    private String instructions;
    @XStreamAlias("instructions_position")
    private String instructionsPosition;
    private Integer id;
    @XStreamAlias("anchor_name")
    private String anchorName;
    @XStreamAlias("parent_id")
    private Integer parentId;
    private Integer level;

    public String getTitle() {
        return title;
    }

    public String getInstructions() {
        return instructions;
    }

    public String getInstructionsPosition() {
        return instructionsPosition;
    }

    public Integer getId() {
        return id;
    }

    public String getAnchorName() {
        return anchorName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public Integer getLevel() {
        return level;
    }
}
