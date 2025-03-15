package app.damareonc.nedit;

import javax.swing.*;
import java.awt.*;

public final class App extends JFrame
{
    private String fileName = "";
    private String fileContent = "";

    public App()
    {
        super("NEdit");

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

        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(saveAsMenuItem);
        menuBar.add(fileMenu);

        this.add(menuBar, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);

        this.addWindowListener(new WindowCloseListener(this, textArea));
    }

    public void setFileName(final String fileName)
    {
        this.fileName = fileName;
    }

    public void setFileContent(final String fileContent)
    {
        this.fileContent = fileContent;
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