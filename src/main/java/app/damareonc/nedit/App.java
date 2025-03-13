package app.damareonc.nedit;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame
{
    private String fileName = "";
    private String fileContent = "";

    public App()
    {
        super("NEdit");

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem openMenuItem = new JMenuItem("Open...");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        JMenuItem saveAsMenuItem = new JMenuItem("Save As...");
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);

        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(saveAsMenuItem);
        menuBar.add(fileMenu);

        this.add(menuBar, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);

        this.addWindowListener(new WindowCloseListener(this, textArea));
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