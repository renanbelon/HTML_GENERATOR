package view;

import javax.swing.*;

/**
 * Created by Covaciu on 09/02/2016.
 */
public class View extends JFrame {
    public JButton paragraphButton;
    public JButton addCssFileButton;
    public JButton titleButton;
    public JButton h126Button;
    public JButton imageButton;
    public JPanel rootPanel;
    public JButton generateButton;

    public View() {
        super("HTML GENERATOR");
        pack();
        setContentPane(rootPanel);
        setSize(500, 500);
        setLocationRelativeTo(null);
    }
}
