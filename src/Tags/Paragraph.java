package Tags;

/**
 * Created by Covaciu on 09/02/2016.
 */
public class Paragraph extends Tag {

    String text;

    public Paragraph(String text) {
        setOpeningTag("<p>");
        setClosingTag("</p>");
        setText(text);
    }

    public Paragraph() {
        setOpeningTag("<p>");
        setClosingTag("</p>");
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public String getParagraph() {
        return getOpeningTag() + text + getClosingTag() + "\n";
    }
}
