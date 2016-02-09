package controller;

import view.View;

/**
 * Created by Covaciu on 09/02/2016.
 */
public class Controller {
    private View view;

    public Controller(View view) {
        setView(view);
    }

    public void setView(View view) {
        this.view = view;
    }

    public void start() {
        view.setVisible(true);
    }
}
