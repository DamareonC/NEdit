package app.damareonc.nedit;

import com.formdev.flatlaf.FlatLightLaf;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public final class Main
{
    public static void main(final String @NotNull [] args)
    {
        FlatLightLaf.setup();

        final App app = new App(args.length == 0 ? "" : args[0]);

        app.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        app.setSize(640, 480);
        app.setVisible(true);
    }
}