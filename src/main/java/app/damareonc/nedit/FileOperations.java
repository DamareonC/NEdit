package app.damareonc.nedit;

import javax.swing.*;
import java.io.*;
import java.util.List;

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
                final FileReader fileReader = new FileReader(fileChooser.getSelectedFile());
                final BufferedReader bufferedReader = new BufferedReader(fileReader);
                final StringBuilder stringBuilder = new StringBuilder();
                String line;

                while ((line = bufferedReader.readLine()) != null)
                {
                    stringBuilder.append(line).append('\n');
                }

                bufferedReader.close();
                stringBuilder.reverse().deleteCharAt(0).reverse();

                if (!app.getFileContent().equals(textArea.getText()))
                {
                    final int saveOption = JOptionPane.showConfirmDialog(app, String.format("There are unsaved changes in %s. Do you want to save changes before opening another file?", !app.getFileName().isEmpty() ? app.getFileName() : "<unnamed>"));

                    if (saveOption == JOptionPane.CANCEL_OPTION) return;
                    else if (saveOption == JOptionPane.YES_OPTION);
                        //Save function goes here
                }

                app.setTitle("NEdit - " + fileChooser.getSelectedFile().getName());
                app.setFilePath(fileChooser.getSelectedFile().getParent());
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

    public static void fileSave(final App app, final JTextArea textArea)
    {
        if (app.getFileContent().equals(textArea.getText())) return;

        if (app.getFileName().isEmpty() || app.getFilePath().isEmpty());
            //Save as function goes here
        else
        {
            try
            {
                final FileWriter fileWriter = new FileWriter(app.getFilePath() + "/" + app.getFileName());
                final BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                final List<String> lines = textArea.getText().lines().toList();

                for (String line : lines)
                {
                    if (lines.getLast().equals(line))
                    {
                        bufferedWriter.write(line);
                    }
                    else
                    {
                        bufferedWriter.write(line + '\n');
                    }
                }

                bufferedWriter.close();
                app.setFileContent(String.join("\n", lines));
            }
            catch (IOException e)
            {
                JOptionPane.showMessageDialog(app, "Could not open file.", "Error Opening File", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static void newFile(final App app, final JTextArea textArea)
    {
        app.setTitle("NEdit");
        app.setFilePath("");
        app.setFileName("");
        app.setFileContent("");
        textArea.setText("");
    }
}