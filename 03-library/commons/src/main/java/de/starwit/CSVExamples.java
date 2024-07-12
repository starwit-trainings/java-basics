package de.starwit;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CSVExamples {

    static Logger log = LogManager.getLogger(CSVExamples.class.getName());
    
    private String fileLocation = "";

    public CSVExamples(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public void outputCSV() {
        Reader in;
        try {
            in = new FileReader(fileLocation, StandardCharsets.UTF_8);

            CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                .setHeader("id","name","leauge")
                .setDelimiter(";")
                .setSkipHeaderRecord(true)
                .build();                
            
            Iterable<CSVRecord> records = csvFormat.parse(in);;
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

    public String getFileLocation() {
        return fileLocation;
    }
}
