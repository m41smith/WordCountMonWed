package bsu.comp152;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class Main {

    public static void main(String[] args){
        var filePath = Paths.get("warpeace.txt");
        List<String> allLines = null;
        try {
            allLines = Files.readAllLines(filePath);
        }
        catch (IOException e){
            System.out.println("Error reading file");
        }
        if (allLines == null)
            System.exit(-1);
        var wordCount = new HashMap<String, Integer>();
        for (var lines : allLines){
            var wordsInLine = lines.split(" ");
            for (var word : wordsInLine){
                var lowerCaseWord = word.toLowerCase(Locale.ROOT);
                if (wordCount.containsKey(lowerCaseWord)){
                    var currentCount = wordCount.get(word.toLowerCase(Locale.ROOT));
                    wordCount.replace(lowerCaseWord, ++currentCount);
                }
                else {
                    wordCount.put(lowerCaseWord, 1);
                }
            }
        }
        var keys = wordCount.keySet();
        for (var key: keys){
            System.out.println(key + ": "+ wordCount.get(key));
        }
    }
}
