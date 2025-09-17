package app.damareonc.nedit.menus;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

import app.damareonc.nedit.textareas.FileContentTextArea;

public class ViewMenu extends JMenu
{
    public ViewMenu(@NotNull final FileContentTextArea fileContentTextArea)
    {
        super("View");

        final JMenuItem increaseFontSizeMenuItem = new JMenuItem("Increase Font Size");
        final JMenuItem decreaseFontSizeMenuItem = new JMenuItem("Decrease Font Size");
        final JMenuItem resetFontSizeMenuItem = new JMenuItem("Reset Font Size");
        final JCheckBoxMenuItem wordWrapMenuItem = new JCheckBoxMenuItem("Word Wrap");

        this.add(increaseFontSizeMenuItem);
        this.add(decreaseFontSizeMenuItem);
        this.add(resetFontSizeMenuItem);
        this.addSeparator();
        this.add(wordWrapMenuItem);

        increaseFontSizeMenuItem.addActionListener(actionEvent -> fileContentTextArea.increaseFontSize());
        decreaseFontSizeMenuItem.addActionListener(actionEvent -> fileContentTextArea.decreaseFontSize());
        resetFontSizeMenuItem.addActionListener(actionEvent -> fileContentTextArea.resetFontSize());
        wordWrapMenuItem.addActionListener(actionEvent -> fileContentTextArea.setLineWrap(wordWrapMenuItem.getState()));
    }
}
