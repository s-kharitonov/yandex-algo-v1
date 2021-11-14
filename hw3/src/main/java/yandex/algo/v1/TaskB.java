package yandex.algo.v1;

import java.io.*;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toSet;

public class TaskB {
    private static final String INPUT_FILE_PATH = "input.txt";
    private static final String OUTPUT_FILE_PATH = "output.txt";
    private static final String DELIMITER = " ";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            Set<Integer> uniqueFirstSequence = Arrays.stream(reader.readLine().split(DELIMITER))
                    .map(Integer::parseInt)
                    .collect(toSet());
            int[] secondSequence = Arrays.stream(reader.readLine().split(DELIMITER))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            Set<Integer> sortedDisjunction = new TreeSet<>();

            for (int number : secondSequence) {
                if (uniqueFirstSequence.contains(number)) {
                    sortedDisjunction.add(number);
                }
            }

            String result = sortedDisjunction.stream()
                    .map(String::valueOf)
                    .collect(joining(DELIMITER));

            writer.write(result);
        }
    }
}
