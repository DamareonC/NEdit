package app.damareonc.nedit;

import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        App app = new App();

        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(640, 480);
        app.setVisible(true);
    }
}