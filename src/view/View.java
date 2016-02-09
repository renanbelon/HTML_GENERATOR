package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Covaciu on 09/02/2016.
 */
public class View extends JFrame {
    private JButton paragraphButton;
    private JButton addCssFileButton;
    private JButton titleButton;
    private JButton h126Button;
    private JButton imageButton;
    private JPanel rootPanel;

    public View() {
        super("HTML GENERATOR");
        pack();
        setContentPane(rootPanel);
        setSize(500, 500);
        setLocationRelativeTo(null);
        titleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(rootPanel, "You clicked the title");
            }
        });
    }
}
