package Tags;

/**
 * Created by Covaciu on 09/02/2016.
 */
public class Title extends Tag {

    private String title;

    public Title() {
        setOpeningTag("<title>");
        setClosingTag("</title>");
    }

    public Title(String title) {
        setTitle(title);
        setOpeningTag("<title>");
        setClosingTag("</title>");
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public String getHTML() {
        return getOpeningTag() + getTitle() + getClosingTag();
    }
}
