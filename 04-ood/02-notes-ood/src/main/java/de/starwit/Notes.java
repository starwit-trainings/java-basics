package de.starwit;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.starwit.commands.AddCommand;
import de.starwit.commands.Command;
import de.starwit.commands.DeleteCommand;
import de.starwit.commands.ExitCommand;
import de.starwit.commands.GetCommand;
import de.starwit.commands.PrintCommand;
import de.starwit.commands.SetCommand;

public class Notes {
    static Logger log = LogManager.getLogger(Notes.class.getName());

    public static Notebook notebook;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        log.info("Notes app started");

        notebook = new Notebook();
        log.info("Notebook ready.");

        while (true) {
            String inputLine = scanner.nextLine();
            if (inputLine.length() == 0) {
                continue;
            }

            Command command = parseCommand(inputLine);            
            command.executeOn(notebook);

            if (command instanceof ExitCommand) {
                break;
            }
        }

        scanner.close();
    }

    public static Command parseCommand(String line) {
        String[] commandParts = line.split(" ", 2);
        String command = commandParts[0];
        String args = "";
        if (commandParts.length == 2) {
            args = commandParts[1];
        }

        Command parsedCommand = switch(command) {
            case "add" -> new AddCommand(args);
            case "delete" -> new DeleteCommand(args);
            case "get" -> new GetCommand(args);
            case "set" -> new SetCommand(args);
            case "print" -> new PrintCommand();
            case "exit" -> new ExitCommand();
            default -> {
                throw new IllegalArgumentException();
            }
        };

        return parsedCommand;
    }

}