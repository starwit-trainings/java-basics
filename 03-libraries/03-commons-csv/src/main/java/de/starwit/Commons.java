package de.starwit;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.text.diff.EditScript;
import org.apache.commons.text.diff.StringsComparator;
import org.apache.commons.text.similarity.LongestCommonSubsequence;
import org.apache.commons.text.similarity.LongestCommonSubsequenceDistance;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Commons {
    static Logger log = LogManager.getLogger(Commons.class.getName());

    public static void main(String[] args) throws Exception {
        log.info("Commons app started");

        printCSV("data/bundesliga_clubs.csv");
    }

    public static void printCSV(String fileLocation) {
        Reader in;
        try {
            in = new FileReader(fileLocation, StandardCharsets.UTF_8);

            CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                .setHeader("id","name","league")
                .setDelimiter(";")
                .setSkipHeaderRecord(true)
                .get();                
            
            Iterable<CSVRecord> records = csvFormat.parse(in);
            for (CSVRecord record : records) {
                String clubName = record.get(1);
                int clubLeague = Integer.parseInt(record.get(2));
                log.debug(clubName + " " + clubLeague);
            }             
        } catch (FileNotFoundException e) {
            log.error("Can't find csv file " + e.getMessage());
        } catch (IOException e) {
            log.error("Can't access csv file " + e.getMessage());
        }       
    }
}
