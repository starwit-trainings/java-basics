package de.starwit.commands;

import de.starwit.Notebook;

public class DeleteCommand implements Command {
    private int id;

    public DeleteCommand(String args) {
        int id = Integer.parseInt(args);
        this.id = id;
    }

    @Override
    public void executeOn(Notebook notebook) {
        notebook.deletePage(this.id);
    }
}
