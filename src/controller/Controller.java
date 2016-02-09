package controller;

import Tags.H;
import Tags.Paragraph;
import Tags.Title;
import view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

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
            updateHTML("\n<head>\n" + title.getHTML());
            view.titleButton.setEnabled(false);
            view.addCssFileButton.setEnabled(true);
        } else if (e.getSource() == view.addCssFileButton) {
            JFileChooser fc = new JFileChooser();
            int returnVal = fc.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fc.getSelectedFile();
                updateHTML("<link href='https://fonts.googleapis.com/css?family=Roboto+Mono' rel='stylesheet' type='text/css'>\n");
                updateHTML(getCSSText(selectedFile.getAbsolutePath()));
                updateHTML("<meta charset=\"UTF-8\">\n</head>\n<body>\n");
                view.addCssFileButton.setEnabled(false);
                view.paragraphButton.setEnabled(true);
                view.imageButton.setEnabled(true);
                view.generateButton.setEnabled(true);
                view.h126Button.setEnabled(true);
                System.out.println(getHTML());
            }
        } else if (e.getSource() == view.paragraphButton) {
            String text = JOptionPane.showInputDialog(null, "Introdu textul: ", "Paragraf", JOptionPane.INFORMATION_MESSAGE);
            if (!text.equals(null)) {
                Paragraph paragraph = new Paragraph(text);
                updateHTML("\n" + paragraph.getHTML());
                System.out.println(getHTML());
            }
        } else if (e.getSource() == view.h126Button) {
            String text = JOptionPane.showInputDialog(null, "Introdu textul: ", "H", JOptionPane.INFORMATION_MESSAGE);
            if (!text.equals(null)) {
                Object options[] = {
                        "h1", "h2", "h3", "h4", "h5", "h6"
                };
                int type = JOptionPane.showOptionDialog(null, "Alege tipul:", "H", JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                H h = new H(text, type + 1);
                updateHTML("\n" + h.getHTML());
                System.out.println(getHTML());
            }
        } else if (e.getSource() == view.imageButton) {

        } else if (e.getSource() == view.generateButton) {
            updateHTML("\n</body>\n</html>");
            System.out.println(getHTML());
            createIndex();
        }
    }

    private void createIndex() {
        File file = new File("index.html");
        if (file.exists())
            file.delete();
        try {
            file.createNewFile();
            PrintStream printStream = new PrintStream(file);
            System.setOut(printStream);
            System.out.println(getHTML());
            System.exit(-1);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    private String getCSSText(String absolutePath) {
        BufferedReader br = null;
        String htmlPart = "<style>\n";
        try {

            String sCurrentLine;

            br = new BufferedReader(new FileReader(absolutePath));

            while ((sCurrentLine = br.readLine()) != null) {
                htmlPart += (sCurrentLine + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        htmlPart += "\n</style>";
        return htmlPart;
    }
}
