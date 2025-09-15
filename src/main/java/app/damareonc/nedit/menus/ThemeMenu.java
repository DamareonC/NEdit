package app.damareonc.nedit.menus;

import javax.swing.*;

import app.damareonc.nedit.util.ThemeUtil;

public final class ThemeMenu extends JMenu
{
    final JList<String> themeList = new JList<>(new String[]{"FlatLaf Light", "FlatLaf Dark", "FlatLaf IntelliJ", "FlatLaf Darcula", "FlatLaf macOS Light", "FlatLaf macOS Dark"});

    public ThemeMenu()
    {
        super("Theme");

        this.add(themeList);

        themeList.setSelectedIndex(0);
        themeList.addListSelectionListener(listSelectionEvent -> ThemeUtil.themeChange(themeList.getSelectedIndex()));
    }
}
