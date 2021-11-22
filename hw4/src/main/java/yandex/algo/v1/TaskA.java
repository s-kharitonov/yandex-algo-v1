package yandex.algo.v1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class TaskA {
    private static final String INPUT_FILE_PATH = "input.txt";
    private static final String OUTPUT_FILE_PATH = "output.txt";
    private static final String DELIMITER = " ";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            int pairsCount = Integer.parseInt(reader.readLine());
            Map<String, String> dictionary1 = new HashMap<>();
            Map<String, String> dictionary2 = new HashMap<>();

            for (int i = 0; i < pairsCount; i++) {
                String[] synonyms = reader.readLine()
                        .split(DELIMITER);

                dictionary1.put(synonyms[0], synonyms[1]);
                dictionary2.put(synonyms[1], synonyms[0]);
            }

            String word = reader.readLine();
            String synonym = dictionary1.get(word);

            if (synonym == null) {
                synonym = dictionary2.get(word);
            }

            writer.write(synonym);
        }
    }
}
