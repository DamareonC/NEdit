package app.damareonc.nedit.event;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import app.damareonc.nedit.App;
import app.damareonc.nedit.util.FileUtil;

public final class WindowCloseAdapter extends WindowAdapter
{
    private final App app;
    private final JTextArea textArea;

    public WindowCloseAdapter(@NotNull final App app, @NotNull final JTextArea textArea)
    {
        this.app = app;
        this.textArea = textArea;
    }

    @Override
    public void windowClosing(@NotNull final WindowEvent windowEvent)
    {
        if (!this.app.getFileContent().equals(this.textArea.getText()))
        {
            final int option = JOptionPane.showConfirmDialog(this.app, String.format("There are unsaved changes in %s. Do you want to save changes before closing NEdit?", !this.app.getFileName().isEmpty() ? this.app.getFileName() : "<unnamed>"));

            if (option == JOptionPane.YES_OPTION || option == JOptionPane.NO_OPTION)
            {
                if (option == JOptionPane.YES_OPTION)
                {
                    final boolean fileSaved = FileUtil.fileSave(this.app, this.textArea);

                    if (!fileSaved) return;
                }

                System.exit(0);
            }
        }
        else
        {
            System.exit(0);
        }
    }
}