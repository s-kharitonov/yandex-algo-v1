package yandex.algo.v1;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TaskA {
    private static final String INPUT_FILE_PATH = "input.txt";
    private static final String OUTPUT_FILE_PATH = "output.txt";
    private static final String DELIMITER = " ";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            int[] numbers = Arrays.stream(reader.readLine().split(DELIMITER))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            Set<Integer> uniqueNumbers = new HashSet<>();

            for (int number: numbers) {
                uniqueNumbers.add(number);
            }

            writer.write(String.valueOf(uniqueNumbers.size()));
        }
    }
}
