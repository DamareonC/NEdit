package app.damareonc.nedit;

import javax.swing.*;

public final class Main
{
    public static void main(String[] args)
    {
        final App app = new App();

        app.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        app.setSize(640, 480);
        app.setVisible(true);
    }
}