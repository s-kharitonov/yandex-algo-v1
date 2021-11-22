package yandex.algo.v1;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TaskB {
    private static final String INPUT_FILE_PATH = "input.txt";
    private static final String OUTPUT_FILE_PATH = "output.txt";
    private static final String DELIMITER = " ";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            Map<String, Integer> wordsByCounter = new HashMap<>();

            String result = reader.lines()
                    .filter(line -> !line.isEmpty())
                    .flatMap(line -> Arrays.stream(line.split(DELIMITER)))
                    .map(String::trim)
                    .map(word -> {
                        int counter = wordsByCounter.getOrDefault(word, 0);

                        wordsByCounter.compute(word, (key, value) -> value == null ? 1 : value + 1);

                        return String.valueOf(counter);
                    })
                    .collect(Collectors.joining(DELIMITER));

            writer.write(result);
        }
    }
}

