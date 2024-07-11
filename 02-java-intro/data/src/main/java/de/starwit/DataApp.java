package de.starwit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DataApp {
    static Logger log = LogManager.getLogger(DataApp.class.getName());

    private static int globalNumber = 10;

    public static void main(String[] args) throws Exception {
        log.info("programm started");
        String example = "String example";
        int aNumber = 10;
        double aFloatingNumber = 1.5;
        boolean isTrue = false;

        log.info("putting it all together: " + example + " " + aNumber + " " + aFloatingNumber + " " + isTrue);

        StringBuffer sb =  new StringBuffer();
        sb.append(example);
        sb.append(aNumber);
        sb.append(aFloatingNumber);
        sb.append(isTrue);
        log.info("Using string buffers " + sb.toString());

        moreDataTypes();
        calculations();
    }

    private static void moreDataTypes() {
        log.info("more data types");
        long bigNumber = 654234235;
        short smallNumber = 500;
        byte evenSmallerNumber = 127;

        char singleCharacter = 'a';

        StringBuffer sb =  new StringBuffer();
        sb.append(bigNumber);
        sb.append(smallNumber);
        sb.append(evenSmallerNumber);
        sb.append(singleCharacter);
        log.info("Using string buffers for more data types " + sb.toString());        
    }

    private static void calculations() {
        log.info("calculating with Java");
        int result = globalNumber + globalNumber;
        log.info(result);
        result = globalNumber + 100;
        log.info(result);
        result = globalNumber - 100;
        log.info(result);
    }
}
