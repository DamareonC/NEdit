package app.damareonc.nedit.utils;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.io.*;
import java.util.List;

import app.damareonc.nedit.App;

public final class FileUtil
{
    public static void fileNew(@NotNull final App app, @NotNull final JTextArea textArea)
    {
        if (!app.fileContent.equals(textArea.getText()))
        {
            final int option = JOptionPane.showConfirmDialog(app, String.format("There are unsaved changes in %s. Do you want to save changes before creating a new file?", !app.fileName.isEmpty() ? app.fileName : "<unnamed>"));

            if (option == JOptionPane.YES_OPTION || option == JOptionPane.NO_OPTION)
            {
                if (option == JOptionPane.YES_OPTION)
                {
                    final boolean fileSaved = fileSave(app, textArea);

                    if (!fileSaved) return;
                }

                newFile(app, textArea);
            }
        }
        else
        {
            newFile(app, textArea);
        }
    }

    public static void fileOpen(@NotNull final App app, @NotNull final JTextArea textArea)
    {
        final JFileChooser fileChooser = new JFileChooser();
        final int option = fileChooser.showOpenDialog(app);

        if (option == JFileChooser.APPROVE_OPTION)
        {
            openFile(app, textArea, fileChooser.getSelectedFile());
        }
        else if (option == JFileChooser.ERROR_OPTION)
        {
            JOptionPane.showMessageDialog(app, "Could not open the file.", "Error Opening File", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void fileOpenFromArgument(@NotNull final App app, @NotNull final JTextArea textArea, @NotNull final String filePath)
    {
        openFile(app, textArea, new File(filePath));
    }

    public static boolean fileSave(@NotNull final App app, @NotNull final JTextArea textArea)
    {
        if (app.fileContent.equals(textArea.getText())) return true;

        if (app.fileName.isEmpty() || app.filePath.isEmpty())
        {
            return fileSaveAs(app, textArea);
        }
        else
        {
            try
            {
                File file = new File(app.filePath + "/" + app.fileName);

                saveFile(file, textArea);
                app.fileContent = textArea.getText();

                return true;
            }
            catch (IOException e)
            {
                JOptionPane.showMessageDialog(app, "Could not open file.", "Error Opening File", JOptionPane.ERROR_MESSAGE);
            }
        }

        return false;
    }

    public static boolean fileSaveAs(@NotNull final App app, @NotNull final JTextArea textArea)
    {
        final JFileChooser fileChooser = new JFileChooser();
        final int option = fileChooser.showSaveDialog(app);

        if (option == JFileChooser.APPROVE_OPTION)
        {
            try
            {
                saveFile(fileChooser.getSelectedFile(), textArea);
                setAppProperties(app, fileChooser.getSelectedFile(), textArea.getText());

                return true;
            }
            catch (IOException e)
            {
                JOptionPane.showMessageDialog(app, "Could not open file.", "Error Opening File", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (option == JFileChooser.ERROR_OPTION)
        {
            JOptionPane.showMessageDialog(app, "Could not save the file.", "Error Saving File", JOptionPane.ERROR_MESSAGE);
        }

        return false;
    }

    private static void newFile(@NotNull final App app, @NotNull final JTextArea textArea)
    {
        app.setTitle("NEdit - <unnamed>");
        app.filePath = "";
        app.fileName = "";
        app.fileContent = "";
        textArea.setText("");
    }

    private static void openFile(@NotNull final App app, @NotNull final JTextArea textArea, @NotNull final File file)
    {
        try
        {
            final FileReader fileReader = new FileReader(file);
            final BufferedReader bufferedReader = new BufferedReader(fileReader);
            final StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null)
            {
                stringBuilder.append(line).append('\n');
            }

            bufferedReader.close();
            stringBuilder.reverse().deleteCharAt(0).reverse();

            if (!app.fileContent.equals(textArea.getText()))
            {
                final int saveOption = JOptionPane.showConfirmDialog(app, String.format("There are unsaved changes in %s. Do you want to save changes before opening another file?", !app.fileName.isEmpty() ? app.fileName : "<unnamed>"));

                if (saveOption == JOptionPane.CANCEL_OPTION) return;
                else if (saveOption == JOptionPane.YES_OPTION)
                {
                    final boolean fileSaved = fileSave(app, textArea);

                    if (!fileSaved) return;
                }
            }

            textArea.setText(stringBuilder.toString());
            setAppProperties(app, file, stringBuilder.toString());
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

    private static void saveFile(@NotNull final File file, @NotNull final JTextArea textArea) throws IOException
    {
        final FileWriter fileWriter = new FileWriter(file);
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
    }

    private static void setAppProperties(@NotNull final App app, @NotNull final File file, @NotNull final String fileContent)
    {
        app.setTitle(String.format("NEdit - %s", file.getName()));
        app.filePath = file.getParent();
        app.fileName = file.getName();
        app.fileContent = fileContent;
    }
}