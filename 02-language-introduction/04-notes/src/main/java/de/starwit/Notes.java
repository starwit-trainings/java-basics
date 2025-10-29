package de.starwit;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Notes {
    static Logger log = LogManager.getLogger(Notes.class.getName());

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        log.info("Notes app started");

        log.info("Input notebook size:");
        int size = scanner.nextInt();

        String[] notebook = new String[size];
        log.info("Notebook ready (size=" + size + ")");

        boolean exit = false;

        while (!exit) {
            String inputLine = scanner.nextLine();
            if (inputLine.length() == 0) {
                continue;
            }

            String[] command = parseCommand(inputLine);

            switch(command[0]) {
                case "set" -> {
                    int pageIndex = Integer.parseInt(command[1]);
                    setPage(notebook, command[2], pageIndex);
                }
                case "get" -> {
                    int pageIndex = Integer.parseInt(command[1]);
                    log.info(getPage(notebook, pageIndex));
                }
                case "print" -> {
                    for (int i = 0; i < notebook.length; i++) {
                        log.info(i + ": " + notebook[i]);
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

    public static void setPage(String[] notebook, String page, int pageIndex) {
        notebook[pageIndex] = page;
    }

    public static String getPage(String[] notebook, int pageIndex) {
        return notebook[pageIndex];
    }

}
