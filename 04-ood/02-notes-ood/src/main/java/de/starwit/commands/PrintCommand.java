package de.starwit.commands;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.starwit.Notebook;
import de.starwit.Page;

public class PrintCommand implements Command {

    static Logger log = LogManager.getLogger(PrintCommand.class.getName());

    @Override
    public void executeOn(Notebook notebook) {
        List<Page> pages = notebook.getAllPages();
        for (int i = 0; i < pages.size(); i++) {
            log.info(i + ": " + pages.get(i));
        }
    }
    
}
