package app.damareonc.nedit;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public final class WindowCloseListener extends WindowAdapter
{
    private final App app;
    private final JTextArea textArea;

    public WindowCloseListener(final App app, final JTextArea textArea)
    {
        this.app = app;
        this.textArea = textArea;
    }

    @Override
    public void windowClosing(final WindowEvent windowEvent)
    {
        if (!this.app.getFileContent().equals(this.textArea.getText()))
        {
            final int option = JOptionPane.showConfirmDialog(this.app, String.format("There are unsaved changes in %s. Do you want to save changes before closing NEdit?", !this.app.getFileName().isEmpty() ? this.app.getFileName() : "<unnamed>"));

            if (option == JOptionPane.YES_OPTION || option == JOptionPane.NO_OPTION)
            {
                this.app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                if (option == JOptionPane.YES_OPTION);
                    //Save function goes here
            }
            else
            {
                this.app.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        }
    }
}