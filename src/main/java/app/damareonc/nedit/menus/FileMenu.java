package app.damareonc.nedit.menus;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;

import app.damareonc.nedit.App;
import app.damareonc.nedit.utils.FileUtil;

public class FileMenu extends JMenu
{
    public FileMenu(@NotNull final App app, @NotNull final JTextArea textArea)
    {
        super("File");

        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem openMenuItem = new JMenuItem("Open...");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        JMenuItem saveAsMenuItem = new JMenuItem("Save As...");

        this.add(newMenuItem);
        this.add(openMenuItem);
        this.add(saveMenuItem);
        this.add(saveAsMenuItem);

        newMenuItem.addActionListener(actionEvent -> FileUtil.fileNew(app, textArea));
        openMenuItem.addActionListener(actionEvent -> FileUtil.fileOpen(app, textArea));
        saveMenuItem.addActionListener(actionEvent -> FileUtil.fileSave(app, textArea));
        saveAsMenuItem.addActionListener(actionEvent -> FileUtil.fileSaveAs(app, textArea));
    }
}
