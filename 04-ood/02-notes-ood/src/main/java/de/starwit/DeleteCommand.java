package de.starwit;

public class DeleteCommand implements Command {

    private int id;

    public DeleteCommand(int id) {
        this.id = id;
    }

    @Override
    public void executeOn(Notebook notebook) {
        notebook.deletePage(this.id);
    }
    
}
