package de.starwit;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LambdaApp {

    static Logger log = LogManager.getLogger(LambdaApp.class.getName());

    public static void main(String[] args) throws Exception {

        // lambda without params
        Runnable r = () -> log.info("Hello World!");
        r.run();

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(5);
        numbers.add(9);
        numbers.add(8);
        numbers.add(1);
        numbers.forEach((n) -> {
            log.info(n);
        });
        numbers.forEach(n -> {
            if(n % 2 == 0) {
                log.info("Even number " + n);
            }
        });

        // as a hint -> Stream API can do a lot of stuff with lambdas
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        log.info("Sum: " + sum);

        // Let's define a named lambda
        StringFunction question = (s) -> s + ", are you happy?";

        ArrayList<String> names = new ArrayList<String>();
        names.add("Max");
        names.add("Peter");
        names.add("Lisa");
        names.add("Maria");
        names.add("Anton");

        
        // apply functions on every element
        names.forEach(n -> log.info(question.run(n)));
        names.forEach(n -> log.info(n.toUpperCase()));
        
        // let's collect all names
        StringBuffer allNames =  new StringBuffer();
        names.forEach(n -> {
            allNames.append(n);
        });
        log.info(allNames.toString());
    }

    @FunctionalInterface
    interface StringFunction {
        String run(String str);
    }
}
