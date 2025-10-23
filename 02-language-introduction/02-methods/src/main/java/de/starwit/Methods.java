package de.starwit;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Methods {
    static Logger log = LogManager.getLogger(Methods.class.getName());

    public static void main(String[] args) throws Exception {
        log.info(getHello() + " World");

        // Make a decision using if
        int i = getFive();
        if(i < 10) {
            log.info("smaller");
        } else {
            log.info("larger");
        }

        // Make a decision using switch
        int number = 2;
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

        // Loop for a specified number of times using for
        for (int j = 0; j < getFive(); j++) {
            log.debug("Running in for loop " + j);
        }

        // Loop using a while loop (always remember increasing the counter!)
        int k = 0;
        while(k <= 5) {
            log.debug("Running in while loop " + k);
            k++;
        }

        // read input from console and try to parse it as number
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
    
        log.info("your input was " + input);
    
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            log.error("Couldn't parse number");
        }
    }

    public static int getFive() {
        return 5;
    }

    public static String getHello() {
        return "Hello";
    }

    public static int add(int a, int b) {
        return a + b;
    }

}
