package de.starwit.commands;

import de.starwit.Notebook;

public interface Command {
    public void executeOn(Notebook notebook);
}
