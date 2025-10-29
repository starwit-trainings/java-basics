package de.starwit;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Notes {
    static Logger log = LogManager.getLogger(Notes.class.getName());

    public static Notebook notebook;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        log.info("Notes app started");

        notebook = new Notebook();
        log.info("Notebook ready.");

        boolean exit = false;

        while (!exit) {
            String inputLine = scanner.nextLine();
            if (inputLine.length() == 0) {
                continue;
            }

            String[] command = parseCommand(inputLine);

            switch(command[0]) {
                case "add" -> {
                    Command cmd = new AddCommand(command[1] + " " + command[2]);
                    cmd.executeOn(notebook);
                }
                case "delete" -> {
                    int pageIndex = Integer.parseInt(command[1]);
                    Command cmd = new DeleteCommand(pageIndex);
                    cmd.executeOn(notebook);
                }
                case "get" -> {
                    int pageIndex = Integer.parseInt(command[1]);
                    log.info(notebook.getPage(pageIndex));
                }
                case "print" -> {
                    List<Page> pages = notebook.getAllPages();
                    for (int i = 0; i < pages.size(); i++) {
                        log.info(i + ": " + pages.get(i));
                    }
                }
                case "exit" -> {
                    exit = true;
                }
                default -> {
                    log.warn("Unknown command");
                }
            }
        }

        scanner.close();
    }

    public static String[] parseCommand(String line) {
        return line.split(" ", 3);
    }

}