package app.damareonc.nedit;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public final class KeyTypedAdapter extends KeyAdapter
{
    private final App app;
    private final JTextArea textArea;

    public KeyTypedAdapter(final App app, final JTextArea textArea)
    {
        this.app = app;
        this.textArea = textArea;
    }

    @Override
    public void keyReleased(KeyEvent keyEvent)
    {
        final boolean isSaved = this.app.getFileContent().equals(this.textArea.getText());
        final boolean hasName = !this.app.getFileName().isEmpty();

        this.app.setTitle(String.format("NEdit - %s%s", hasName ? this.app.getFileName() : "<unnamed>", isSaved ? "" : "*"));
    }
}