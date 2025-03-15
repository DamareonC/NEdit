package app.damareonc.nedit;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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

    public static void fileOpen(final App app, final JTextArea textArea)
    {
        final JFileChooser fileChooser = new JFileChooser();
        final int option = fileChooser.showOpenDialog(app);

        if (option == JFileChooser.APPROVE_OPTION)
        {
            try
            {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(fileChooser.getSelectedFile()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;

                while ((line = bufferedReader.readLine()) != null)
                {
                    stringBuilder.append(line).append('\n');
                }

                app.setTitle("NEdit - " + fileChooser.getSelectedFile().getName());
                app.setFileName(fileChooser.getSelectedFile().getName());
                app.setFileContent(stringBuilder.toString());
                textArea.setText(stringBuilder.toString());
            }
            catch (FileNotFoundException e)
            {
                JOptionPane.showMessageDialog(app, "Could not open the file.", "Error Opening File", JOptionPane.ERROR_MESSAGE);
            }
            catch (IOException e)
            {
                JOptionPane.showMessageDialog(app, "Could not read file.", "Error Reading File", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (option == JFileChooser.ERROR_OPTION)
        {
            JOptionPane.showMessageDialog(app, "Could not open the file.", "Error Opening File", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void newFile(final App app, final JTextArea textArea)
    {
        app.setTitle("NEdit");
        app.setFileName("");
        app.setFileContent("");
        textArea.setText("");
    }
}
