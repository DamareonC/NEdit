package app.damareonc.nedit.menus;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class ViewMenu extends JMenu
{
    JCheckBoxMenuItem wordWrapMenuItem = new JCheckBoxMenuItem("Word Wrap");

    public ViewMenu(@NotNull final JTextArea fileContentTextArea)
    {
        super("View");

        this.add(wordWrapMenuItem);

        wordWrapMenuItem.addActionListener(actionEvent -> fileContentTextArea.setLineWrap(wordWrapMenuItem.getState()));
    }
}
