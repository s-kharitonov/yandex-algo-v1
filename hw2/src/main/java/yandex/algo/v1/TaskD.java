package yandex.algo.v1;

import java.io.*;

public class TaskD {
    private static final String INPUT_FILE_PATH = "input.txt";
    private static final String OUTPUT_FILE_PATH = "output.txt";
    private static final String DELIMITER = " ";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            String[] numbers = reader.readLine()
                    .split(DELIMITER);
            int counter = 0;

            for (int i = 1; i < numbers.length - 1; i++) {
                int prev = Integer.parseInt(numbers[i - 1]);
                int current = Integer.parseInt(numbers[i]);
                int next = Integer.parseInt(numbers[i + 1]);

                if (current > prev && current > next) {
                    counter++;
                }
            }

            writer.write(String.valueOf(counter));
        }
    }
}
