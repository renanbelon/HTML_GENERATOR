package controller;

import Tags.Title;
import view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Covaciu on 09/02/2016.
 */
public class Controller implements ActionListener {
    private View view;
    String html;

    public Controller(View view) {
        html = "<html>";
        setView(view);
        view.titleButton.addActionListener(this);
        view.addCssFileButton.addActionListener(this);
        view.generateButton.addActionListener(this);
        view.imageButton.addActionListener(this);
        view.paragraphButton.addActionListener(this);
        view.h126Button.addActionListener(this);
        view.paragraphButton.setEnabled(false);
        view.addCssFileButton.setEnabled(false);
        view.imageButton.setEnabled(false);
        view.generateButton.setEnabled(false);
        view.h126Button.setEnabled(false);
    }

    public void setView(View view) {
        this.view = view;
    }

    public String getHTML() {
        return html;
    }

    public void setHTML(String html) {
        this.html = html;
    }

    public void start() {
        view.setVisible(true);
    }

    public void updateHTML(String htmlPart) {
        setHTML(getHTML() + htmlPart);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.titleButton) {
            String text = JOptionPane.showInputDialog(null, "Introdu titlu");
            Title title = new Title(text);
            updateHTML("<head>" + title.getHTML() + "</head><body>");
            view.titleButton.setEnabled(false);
            view.paragraphButton.setEnabled(true);
            view.addCssFileButton.setEnabled(true);
            view.imageButton.setEnabled(true);
            view.generateButton.setEnabled(true);
            view.h126Button.setEnabled(true);
        }
    }
}
