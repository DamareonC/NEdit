package app.damareonc.nedit.event;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import app.damareonc.nedit.App;

public final class KeyTypedAdapter extends KeyAdapter
{
    private final App app;
    private final JTextArea textArea;

    public KeyTypedAdapter(@NotNull final App app, @NotNull final JTextArea textArea)
    {
        this.app = app;
        this.textArea = textArea;
    }

    @Override
    public void keyReleased(@NotNull final KeyEvent keyEvent)
    {
        final boolean isSaved = this.app.getFileContent().equals(this.textArea.getText());
        final boolean hasName = !this.app.getFileName().isEmpty();

        this.app.setTitle(String.format("NEdit - %s%s", hasName ? this.app.getFileName() : "<unnamed>", isSaved ? "" : "*"));
    }
}