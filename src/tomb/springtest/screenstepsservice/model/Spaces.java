package tomb.springtest.screenstepsservice.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: tombeadman
 * Date: 20/11/14
 * Time: 23:10
 */

@XStreamAlias("spaces")
public class Spaces {
    @XStreamImplicit
    private List<Space> space;
    public List<Space> getSpaces() {
        return space;
    }

}
