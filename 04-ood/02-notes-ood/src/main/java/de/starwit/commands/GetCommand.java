package de.starwit.commands;

import de.starwit.Notebook;

public class GetCommand implements Command {
    private int id;

    public GetCommand(String args) {
        int id = Integer.parseInt(args);
        this.id = id;
    }

    @Override
    public void executeOn(Notebook notebook) {
        notebook.getPage(id);
    }
}
