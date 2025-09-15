package app.damareonc.nedit;

import com.formdev.flatlaf.*;
import com.formdev.flatlaf.themes.*;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public final class App extends JFrame
{
    private String filePath = "";
    private String fileName = "";
    private String fileContent = "";

    public App(@NotNull String filePath)
    {
        this.setTitle(String.format("NEdit - %s", !this.fileName.isEmpty() ? this.fileName : "<unnamed>"));

        final JMenuBar menuBar = new JMenuBar();
        final JMenu fileMenu = new JMenu("File");
        final JMenuItem newMenuItem = new JMenuItem("New");
        final JMenuItem openMenuItem = new JMenuItem("Open...");
        final JMenuItem saveMenuItem = new JMenuItem("Save");
        final JMenuItem saveAsMenuItem = new JMenuItem("Save As...");

        final JMenu themeMenu = new JMenu("Theme");
        final JList<String> themeList = new JList<>(new String[]{"FlatLaf Light", "FlatLaf Dark", "FlatLaf IntelliJ", "FlatLaf Darcula", "FlatLaf macOS Light", "FlatLaf macOS Dark"});

        final JTextArea textArea = new JTextArea();
        final JScrollPane scrollPane = new JScrollPane(textArea);

        newMenuItem.addActionListener(actionEvent -> FileOperations.fileNew(this, textArea));
        openMenuItem.addActionListener(actionEvent -> FileOperations.fileOpen(this, textArea));
        saveMenuItem.addActionListener(actionEvent -> FileOperations.fileSave(this, textArea));
        saveAsMenuItem.addActionListener(actionEvent -> FileOperations.fileSaveAs(this, textArea));
        themeList.addListSelectionListener(listSelectionEvent -> ThemeOperations.themeChange(themeList.getSelectedIndex()));
        textArea.addKeyListener(new KeyTypedAdapter(this, textArea));

        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(saveAsMenuItem);
        menuBar.add(fileMenu);

        themeList.setSelectedIndex(0);
        themeMenu.add(themeList);
        menuBar.add(themeMenu);

        this.add(menuBar, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);

        this.addWindowListener(new WindowCloseAdapter(this, textArea));

        if (!filePath.isEmpty())
        {
            FileOperations.fileOpenFromArgument(this, textArea, filePath);
        }
    }

    public void setFilePath(final String filePath)
    {
        this.filePath = filePath;
    }

    public void setFileName(final String fileName)
    {
        this.fileName = fileName;
    }

    public void setFileContent(final String fileContent)
    {
        this.fileContent = fileContent;
    }

    public String getFilePath()
    {
        return this.filePath;
    }

    public String getFileName()
    {
        return this.fileName;
    }

    public String getFileContent()
    {
        return this.fileContent;
    }
}