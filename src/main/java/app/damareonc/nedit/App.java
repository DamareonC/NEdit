package app.damareonc.nedit;

import javax.swing.*;
import java.awt.*;

public final class App extends JFrame
{
    private String filePath = "";
    private String fileName = "";
    private String fileContent = "";

    public App(String filePath)
    {
        this.setTitle(String.format("NEdit - %s", !this.fileName.isEmpty() ? this.fileName : "<unnamed>"));

        final JMenuBar menuBar = new JMenuBar();
        final JMenu fileMenu = new JMenu("File");
        final JMenuItem newMenuItem = new JMenuItem("New");
        final JMenuItem openMenuItem = new JMenuItem("Open...");
        final JMenuItem saveMenuItem = new JMenuItem("Save");
        final JMenuItem saveAsMenuItem = new JMenuItem("Save As...");
        final JTextArea textArea = new JTextArea();
        final JScrollPane scrollPane = new JScrollPane(textArea);

        newMenuItem.addActionListener(actionEvent -> FileOperations.fileNew(this, textArea));
        openMenuItem.addActionListener(actionEvent -> FileOperations.fileOpen(this, textArea));
        saveMenuItem.addActionListener(actionEvent -> FileOperations.fileSave(this, textArea));
        saveAsMenuItem.addActionListener(actionEvent -> FileOperations.fileSaveAs(this, textArea));
        textArea.addKeyListener(new KeyTypedAdapter(this, textArea));

        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(saveAsMenuItem);
        menuBar.add(fileMenu);

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