package app.damareonc.nedit;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowCloseListener extends WindowAdapter
{
    private final App APP;
    private final JTextArea TEXT_AREA;

    public WindowCloseListener(final App app, final JTextArea textArea)
    {
        this.APP = app;
        this.TEXT_AREA = textArea;
    }

    @Override
    public void windowClosing(WindowEvent windowEvent)
    {
        if (!this.APP.getFileContent().equals(this.TEXT_AREA.getText()))
        {
            final int OPTION = JOptionPane.showConfirmDialog(this.APP, String.format("There are unsaved changes in %s. Do you want to save changes before creating a new file?", !this.APP.getFileName().isEmpty() ? this.APP.getFileName() : "<unnamed>"));

            if (OPTION == JOptionPane.YES_OPTION || OPTION == JOptionPane.NO_OPTION)
            {
                this.APP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                if (OPTION == JOptionPane.YES_OPTION);
                    //Save function goes here
            }
            else
            {
                this.APP.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        }
    }
}
