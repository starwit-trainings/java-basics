package de.starwit;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Data {
    static Logger log = LogManager.getLogger(Data.class.getName());

    public static void main(String[] args) throws Exception {
        log.info("Please enter some integers:");

        String inputLine = readLine();
        String[] lineItems = splitLine(inputLine);

        if (!isAllInt(lineItems)) {
            log.warn("Input contained non-integer");
            return;
        };

        int[] intItems = convertToIntArray(lineItems);

        double[] output = calculateOutput(intItems);

        log.info("Minimum is: " + output[0]);
        log.info("Maximum is: " + output[1]);
        log.info("Sum is: " + output[2]);
        log.info("Average is: " + output[3]);
    }

    public static String readLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String[] splitLine(String line) {
        return line.split(" ");
    }

    public static boolean isAllInt(String[] lineItems) {
        for (String item : lineItems) {
            try {
                Integer.parseInt(item);
            } catch (NumberFormatException e) {
                return false;
            }
        }

        return true;
    }

    public static int[] convertToIntArray(String[] lineItems) {
        int[] intItems = new int[lineItems.length];
        for (int i = 0; i < lineItems.length; i++) {
            intItems[i] = Integer.parseInt(lineItems[i]);
        }
        return intItems;
    }

    public static double[] calculateOutput(int[] intItems) {
        // minimum, maximum, sum, average
        double[] statValues = new double[4];
        
        statValues[0] = calculateMinimum(intItems);
        statValues[1] = calculateMaximum(intItems);
        statValues[2] = calculateSum(intItems);
        statValues[3] = calculateAverage(intItems);

        return statValues;
    }

    public static double calculateMinimum(int[] arr) {
        int minimum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minimum) {
                minimum = arr[i];
            }
        }
        return minimum;
    }

    public static double calculateMaximum(int[] arr) {
        int maximum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maximum) {
                maximum = arr[i];
            }
        }
        return maximum;
    }

    public static int calculateSum(int[] arr) {
        int sum = 0;
        for (int item : arr) {
            sum += item;
        }
        return sum;
    }

    public static double calculateAverage(int[] arr) {
        return calculateSum(arr) / arr.length;
    }

}
