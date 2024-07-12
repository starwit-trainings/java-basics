package de.starwit;

import org.apache.commons.text.diff.EditScript;
import org.apache.commons.text.diff.StringsComparator;
import org.apache.commons.text.similarity.LongestCommonSubsequence;
import org.apache.commons.text.similarity.LongestCommonSubsequenceDistance;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommonsApp {
    static Logger log = LogManager.getLogger(CommonsApp.class.getName());

    public static void main(String[] args) throws Exception {
        log.info("Commons app started");
        String a = "helloworld?";
        String b = "hello world!";
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        int lcsCount = lcs.apply(a, b);
        log.info("LCS count is " + lcsCount);

        LongestCommonSubsequenceDistance lcsd = new LongestCommonSubsequenceDistance();
        int lcsdCount = lcsd.apply(a,b);
        log.info("Number of characters not shared " + lcsdCount);

        StringsComparator cmp = new StringsComparator(a, b);
        EditScript<Character> script = cmp.getScript();
        int mod = script.getModifications();        
        log.info("Difference " + mod);

        runCSVExamples();
    }

    private static void runCSVExamples() {
        CSVExamples csvEx = new CSVExamples("data/bundesliga_clubs.csv");
        csvEx.outputCSV();
    }
}
