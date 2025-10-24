package de.starwit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParamsApp {
    static Logger log = LogManager.getLogger(ParamsApp.class.getName());

    private static int globalNumber = 10;

    public static void main(String[] args) throws Exception {
        log.info("Param app started");
        for (String param : args) {
            log.debug(param);
        }

        simpleParamExample("test");
        complexParamExample(args);
        log.info(returnParameterExample("hello", "world"));
    }

    private static void simpleParamExample(String s) {
        log.debug("Handed over parameter " + s);
    }

    private static void complexParamExample(String[] params) {
        for (String param : params) {
            log.debug(param);
        }
    }

    private static String returnParameterExample(String s1, String s2) {
        return s1 + s2;
    }
}
