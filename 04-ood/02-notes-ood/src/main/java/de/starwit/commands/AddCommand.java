package de.starwit.commands;

import de.starwit.Notebook;

public class AddCommand implements Command {
    private String text;

    public AddCommand(String args) {
        this.text = args;
    }

    @Override
    public void executeOn(Notebook notebook) {
        notebook.addPage(text);
    }
}
