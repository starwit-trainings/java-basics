package de.starwit;

public class AddCommand implements Command {
    private String text;

    public AddCommand(String text) {
        this.text = text;
    }

    @Override
    public void executeOn(Notebook notebook) {
        notebook.addPage(text);
    }
}
