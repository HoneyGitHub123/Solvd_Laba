package com.airport1.airportsystem;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.lang3.StringUtils;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
//Unique words from file using String Utils and File Utils
public class AirportInfo {
    public static void getUniqueWordsCount() throws IOException {
        File file1 = FileUtils.getFile(AirportSystem.INPUT_FILE);
        File file2 = new File(AirportSystem.OUTPUT_FILE);
        LineIterator lineIterator = FileUtils.lineIterator(file1);
        Set<String> uniqueWords = new HashSet<>();
        int count = 0;
        while (lineIterator.hasNext()) {
            String line = lineIterator.nextLine();
            String[] words = StringUtils.split(line);
            for (String unique:words) {
                if (!(uniqueWords.contains(unique))) {
                    uniqueWords.add(unique);
                    count++;
                }
            }
        }
        System.out.println("Number of unique words:"+count);
       FileUtils.writeStringToFile(file2,String.valueOf(count));
    }}
