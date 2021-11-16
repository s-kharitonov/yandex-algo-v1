package yandex.algo.v1;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class TaskE {
    private static final String INPUT_FILE_PATH = "input.txt";
    private static final String OUTPUT_FILE_PATH = "output.txt";
    private static final String DELIMITER = " ";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            Set<Integer> buttons = Arrays.stream(reader.readLine()
                            .split(DELIMITER))
                    .map(Integer::parseInt)
                    .collect(toSet());
            String number = reader.readLine();
            Set<Integer> missingButtons = new HashSet<>();

            for (int i = 0; i < number.length(); i++) {
                int currentNumber = Character.getNumericValue(number.charAt(i));

                if (!buttons.contains(currentNumber)) {
                    missingButtons.add(currentNumber);
                }
            }

            writer.write(String.valueOf(missingButtons.size()));
        }
    }
}
