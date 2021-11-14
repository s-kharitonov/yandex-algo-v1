package yandex.algo.v1;

import java.io.*;
import java.util.Arrays;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class TaskD {
    private static final String INPUT_FILE_PATH = "input.txt";
    private static final String OUTPUT_FILE_PATH = "output.txt";
    private static final String DELIMITER = " ";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            Set<String> words = reader.lines()
                    .flatMap(line -> Arrays.stream(line.split(DELIMITER)))
                    .map(String::trim)
                    .filter(word -> !word.isEmpty())
                    .collect(toSet());

            writer.write(String.valueOf(words.size()));
        }
    }
}
