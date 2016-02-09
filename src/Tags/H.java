package Tags;

/**
 * Created by Covaciu on 09/02/2016.
 */
public class H extends Tag {

    private int type;
    private String text;

    public H(String text, int type) {
        setText(text);
        setType(type);
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public void setType(int type) {
        if (type == 1) {
            setOpeningTag("<h1>");
            setClosingTag("</h1>");
        } else if (type == 2) {
            setOpeningTag("<h1>");
            setClosingTag("</h1>");
        } else if (type == 3) {
            setOpeningTag("<h1>");
            setClosingTag("</h1>");
        } else if (type == 4) {
            setOpeningTag("<h1>");
            setClosingTag("</h1>");
        } else if (type == 5) {
            setOpeningTag("<h1>");
            setClosingTag("</h1>");
        } else if (type == 6) {
            setOpeningTag("<h1>");
            setClosingTag("</h1>");
        }
        this.type = type;
    }

    public String getHTML() {
        return getOpeningTag() + getText() + getClosingTag();
    }

}
