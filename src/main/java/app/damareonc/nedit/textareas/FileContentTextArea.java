package app.damareonc.nedit.textareas;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;

import app.damareonc.nedit.App;
import app.damareonc.nedit.events.KeyTypedAdapter;

public class FileContentTextArea extends JTextArea
{
    private final float defaultFontSize = this.getFont().getSize();
    private float fontSize = this.getFont().getSize();

    public FileContentTextArea(@NotNull final App app)
    {
        this.addKeyListener(new KeyTypedAdapter(app, this));
    }

    public void increaseFontSize()
    {
        this.setFont(this.getFont().deriveFont(++fontSize));
    }

    public void decreaseFontSize()
    {
        this.setFont(this.getFont().deriveFont(--fontSize));
    }

    public void resetFontSize()
    {
        this.setFont(this.getFont().deriveFont((fontSize = defaultFontSize)));
    }
}
