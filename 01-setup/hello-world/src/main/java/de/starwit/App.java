package de.starwit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
    static Logger log = LogManager.getLogger(App.class.getName());

    public static void main(String[] args) {
        System.out.println("Hello World!");
        log.info("hello world");
        log.debug("hello world");
    }
}
