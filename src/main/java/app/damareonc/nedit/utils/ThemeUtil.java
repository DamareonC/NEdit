package app.damareonc.nedit.utils;

import com.formdev.flatlaf.*;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

public final class ThemeUtil
{
    public static void themeChange(final int selectedIndex)
    {
        switch (selectedIndex)
        {
            case 1 -> FlatDarkLaf.setup();
            case 2 -> FlatIntelliJLaf.setup();
            case 3 -> FlatDarculaLaf.setup();
            case 4 -> FlatMacLightLaf.setup();
            case 5 -> FlatMacDarkLaf.setup();
            default -> FlatLightLaf.setup();
        }

        FlatLaf.updateUILater();
    }
}
