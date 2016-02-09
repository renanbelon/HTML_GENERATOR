package Tags;

/**
 * Created by Covaciu on 09/02/2016.
 */
public class Tag {
    String openingTag;
    String closingTag;

    public Tag() {

    }

    public Tag(String openingTag, String closingTag) {
        setOpeningTag(openingTag);
        setClosingTag(closingTag);
    }

    public void setOpeningTag(String openingTag) {
        this.openingTag = openingTag;
    }

    public void setClosingTag(String closingTag) {
        this.closingTag = closingTag;
    }

    public String getOpeningTag() {
        return this.openingTag;
    }

    public String getClosingTag() {
        return this.closingTag;
    }
}
