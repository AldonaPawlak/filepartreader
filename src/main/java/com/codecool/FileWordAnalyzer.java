package com.codecool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileWordAnalyzer {

    private FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public List<String> getWordsOrderedAlphabetically () throws IOException {
        List<String> content = Arrays.asList(filePartReader.readLines().split("\n"));
        List<String> orderedWords = new ArrayList<>();
        for (int i = 0; i < content.size(); i++ ) {
            String[] line = content.get(i).split(" ");
            for (int j=0; j < line.length; j++) {
                orderedWords.add(line[j].toLowerCase());
            }
        }
        Collections.sort(orderedWords);
        return orderedWords;
    }

    public List<String> getWordsContainingSubstring (String subString ) throws IOException {
        filePartReader.readLines ();
        return null;
    }

    public List<String> getStringsWhichPalindromes () throws IOException {
        filePartReader.readLines();
        return null;
    }
}
