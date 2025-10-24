package de.starwit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class Data {
    static Logger log = LogManager.getLogger(Data.class.getName());

    public static void main(String[] args) throws Exception {
        log.info("program started");
        dataTypes();
        moreDataTypes();
        calculations();
        arrays();
    }

    public static void dataTypes() {
        String example = "String example";
        int aNumber = new Random().nextInt(0, 100 + 1);
        double aFloatingNumber = 1.5d;
        boolean isTrue = false;

        log.info("putting it all together: " + example + " " + aNumber + " " + aFloatingNumber + " " + isTrue);
    }

    public static void moreDataTypes() {
        log.info("more data types");
        long bigNumber = 654234235;
        short smallNumber = 500;
        byte evenSmallerNumber = 127;

        char singleCharacter = 'a';
    }

    public static void calculations() {
        log.info("Calculating with Java");
        int result = globalNumber + globalNumber;
        log.info(result);
        result = globalNumber + 100;
        log.info(result);
        result = globalNumber - 100;
        log.info(result);
    }

    public static void strings() {
        log.info("working with strings");
        String example = "This is an example string";

        log.info("Length of string: " + example.length());
        log.info("Character at position 5: " + example.charAt(5));
        log.info("Uppercase: " + example.toUpperCase());
        log.info("Lowercase: " + example.toLowerCase());
        log.info("Contains 'example': " + example.contains("example"));
        log.info("Replace 'example' with 'sample': " + example.replace("example", "sample"));
    }

    public static void arrays() {
        log.info("Working with arrays");

        // defining an array
        log.info("Creating a string array");
        String[] stringArray = new String[10];
        log.info("Filling array with values using classic for loop");
        for(int i = 0; i < 10; i++) {
            stringArray[i] = "string" + i;
        }

        // output array
        log.info("Outputting array content using for-each loop");
        for (String s : stringArray) {
            log.info(s);
        }

        //access random element
        log.info("Accessing element at index 5");
        log.info(stringArray[5]);

        //how many items in array?
        log.info("Number of items in array: " + stringArray.length);
    }
}
