package de.starwit.commands;

import de.starwit.Notebook;

public class SetCommand implements Command {
    private int id;
    private String newText;

    public SetCommand(String args) {
        String[] argsParts = args.split(" ", 2);
        this.id = Integer.parseInt(argsParts[0]);
        this.newText = argsParts[1];
    }

    @Override
    public void executeOn(Notebook notebook) {
        notebook.editPage(id, newText);
    }
}
