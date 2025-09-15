package app.damareonc.nedit;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

import app.damareonc.nedit.event.*;
import app.damareonc.nedit.menus.*;
import app.damareonc.nedit.util.*;

public final class App extends JFrame
{
    private String filePath = "";
    private String fileName = "";
    private String fileContent = "";

    public App(@NotNull String filePath)
    {
        this.setTitle(String.format("NEdit - %s", !this.fileName.isEmpty() ? this.fileName : "<unnamed>"));

        final JTextArea textArea = new JTextArea();
        final JScrollPane scrollPane = new JScrollPane(textArea);
        final JMenuBar menuBar = new JMenuBar();
        final FileMenu fileMenu = new FileMenu(this, textArea);
        final ThemeMenu themeMenu = new ThemeMenu();

        menuBar.add(fileMenu);
        menuBar.add(themeMenu);

        this.add(scrollPane, BorderLayout.CENTER);
        this.add(menuBar, BorderLayout.NORTH);

        textArea.addKeyListener(new KeyTypedAdapter(this, textArea));
        this.addWindowListener(new WindowCloseAdapter(this, textArea));

        if (!filePath.isEmpty())
        {
            FileUtil.fileOpenFromArgument(this, textArea, filePath);
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