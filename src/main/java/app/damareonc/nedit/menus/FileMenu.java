package app.damareonc.nedit.menus;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;

import app.damareonc.nedit.App;
import app.damareonc.nedit.util.FileUtil;

public class FileMenu extends JMenu
{
    final JMenuItem newMenuItem = new JMenuItem("New");
    final JMenuItem openMenuItem = new JMenuItem("Open...");
    final JMenuItem saveMenuItem = new JMenuItem("Save");
    final JMenuItem saveAsMenuItem = new JMenuItem("Save As...");

    public FileMenu(@NotNull final App app, @NotNull final JTextArea textArea)
    {
        super("File");

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
