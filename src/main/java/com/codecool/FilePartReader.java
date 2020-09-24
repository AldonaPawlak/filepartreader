package com.codecool;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilePartReader {

    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader() {
        this.filePath = "";
        this.fromLine = 0;
        this.toLine = 0;
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) throws IllegalArgumentException {
        if (toLine < fromLine || fromLine < 1) {
            throw new IllegalArgumentException();
        }
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public String read() throws IOException {
        return Files.readString(Paths.get(filePath));
    }

    public String readLines() throws IOException {
        String[] content = read().split("\n");
        String lines = "";
        for (int i = fromLine; i <= toLine; i++ ) {
            lines += content[i] + "\n";
        }
        return lines;
    }
}
