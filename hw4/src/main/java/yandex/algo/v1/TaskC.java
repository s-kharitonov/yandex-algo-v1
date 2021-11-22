package yandex.algo.v1;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class TaskC {
    private static final String INPUT_FILE_PATH = "input.txt";
    private static final String OUTPUT_FILE_PATH = "output.txt";
    private static final String DELIMITER = " ";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            List<String> words = reader.lines()
                    .filter(line -> !line.isEmpty())
                    .flatMap(line -> Arrays.stream(line.split(DELIMITER)))
                    .map(String::trim)
                    .collect(toList());
            Map<String, Integer> wordsByCounter = new HashMap<>();
            String minWord = words.get(0);
            int minWordCounter = 1;

            wordsByCounter.put(minWord, minWordCounter);

            for (int i = 1; i < words.size(); i++) {
                String currentWord = words.get(i);

                wordsByCounter.compute(currentWord, (key, value) -> value == null ? 1 : value + 1);

                int counter = wordsByCounter.get(currentWord);

                if (counter > minWordCounter || (counter == minWordCounter && currentWord.compareTo(minWord) < 0)) {
                    minWord = currentWord;
                    minWordCounter = counter;
                }
            }

            writer.write(minWord);
        }
    }
}
