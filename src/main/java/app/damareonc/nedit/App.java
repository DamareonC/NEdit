package app.damareonc.nedit;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

import app.damareonc.nedit.events.*;
import app.damareonc.nedit.menus.*;
import app.damareonc.nedit.textareas.*;
import app.damareonc.nedit.utils.*;

public final class App extends JFrame
{
    public String filePath = "";
    public String fileName = "";
    public String fileContent = "";

    public App(@NotNull final String filePath)
    {
        this.setTitle(String.format("NEdit - %s", !this.fileName.isEmpty() ? this.fileName : "<unnamed>"));

        final FileContentTextArea fileContentTextArea = new FileContentTextArea(this);
        final JScrollPane scrollPane = new JScrollPane(fileContentTextArea);
        final JMenuBar menuBar = new JMenuBar();
        final FileMenu fileMenu = new FileMenu(this, fileContentTextArea);
        final ThemeMenu themeMenu = new ThemeMenu();
        final ViewMenu viewMenu = new ViewMenu(fileContentTextArea);

        menuBar.add(fileMenu);
        menuBar.add(themeMenu);
        menuBar.add(viewMenu);

        this.add(scrollPane, BorderLayout.CENTER);
        this.add(menuBar, BorderLayout.NORTH);

        this.addWindowListener(new WindowCloseAdapter(this, fileContentTextArea));

        if (!filePath.isEmpty())
        {
            FileUtil.fileOpenFromArgument(this, fileContentTextArea, filePath);
        }
    }
}