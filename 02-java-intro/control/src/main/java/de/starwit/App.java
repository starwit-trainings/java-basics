package de.starwit;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
    static Logger log = LogManager.getLogger(App.class.getName());

    public static void main(String[] args) throws Exception {
        log.info("programm started");
        makeDecision();
        forloops();
        whileloops();
        switching(2);
        readingInput();
    }

    private static void makeDecision() {
        int i = 10;
        if(i < 10) {
            log.info("smaller");
        } else {
            log.info("larger");
        }
    }

	private static void forloops() {
        for (int i = 0; i < 5; i++) {
            log.debug("Running in for loop " + i);
        }
    }

    private static void whileloops() {
        int i = 0;
        while(i <= 5) {
            log.debug("Running in while loop " + i);
            i++; //!
        }
	}
    
    private static void switching(int number) {
        switch (number) {
            case 1:
                log.info("Number was one");
                break;
            case 2:
                log.info("Number was two");
                break;        
            default:
            log.info("Number was something else");
                break;
        }
    }

    private static void readingInput() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        log.info("your input was " + input); 
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            log.error("Couldn't parse number");
        }
            
    }
}
