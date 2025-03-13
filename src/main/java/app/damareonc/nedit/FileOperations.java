package app.damareonc.nedit;

import javax.swing.*;

public final class FileOperations
{
    public static void fileNew(final App app, final JTextArea textArea)
    {
        if (!app.getFileContent().equals(textArea.getText()))
        {
            final int option = JOptionPane.showConfirmDialog(app, String.format("There are unsaved changes in %s. Do you want to save changes before creating a new file?", !app.getFileName().isEmpty() ? app.getFileName() : "<unnamed>"));

            if (option == JOptionPane.YES_OPTION || option == JOptionPane.NO_OPTION)
            {
                if (option == JOptionPane.YES_OPTION);
                    //Save function goes here

                newFile(app, textArea);
            }
        }
        else
        {
            newFile(app, textArea);
        }
    }

    private static void newFile(final App app, final JTextArea textArea)
    {
        app.setFileName("");
        app.setFileContent("");
        textArea.setText("");
    }
}
