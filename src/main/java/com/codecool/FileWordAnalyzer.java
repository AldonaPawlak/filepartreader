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
        subString = subString.toLowerCase();
        List<String> content = Arrays.asList(filePartReader.readLines().split("\n"));
        List<String> wordsWithSubstring = new ArrayList<>();
        for (int i = 0; i < content.size(); i++ ) {
            String[] line = content.get(i).split(" ");
            for (int j=0; j < line.length; j++) {
                String wordToCheck = line[j].toLowerCase();
                if (wordToCheck.contains(subString)) {
                    wordsWithSubstring.add(wordToCheck);
                }
            }
        }
        return wordsWithSubstring;
    }

    public List<String> getStringsWhichPalindromes () throws IOException {
        List<String> content = Arrays.asList(filePartReader.readLines().split("\n"));
        List<String> palindromes = new ArrayList<>();
        for (int i = 0; i < content.size(); i++ ) {
            String[] line = content.get(i).split(" ");
            for (int j=0; j < line.length; j++) {
                String wordToCheck = line[j].toLowerCase();
                if (!wordToCheck.equals("") && !wordToCheck.equals(" ")) {
                    if (wordToCheck.equals(new StringBuilder(wordToCheck).reverse().toString())) {
                        palindromes.add(wordToCheck);
                    }
                }
            }
        }
        return palindromes;
    }
}
