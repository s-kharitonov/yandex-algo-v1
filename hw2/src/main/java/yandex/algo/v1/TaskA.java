package yandex.algo.v1;

import java.io.*;

public class TaskA {
    private static final String INPUT_FILE_PATH = "input.txt";
    private static final String OUTPUT_FILE_PATH = "output.txt";
    private static final String DELIMITER = " ";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            String[] numbers = reader.readLine().split(DELIMITER);
            int prevNumber = Integer.parseInt(numbers[0]);

            for (int i = 1; i < numbers.length; i++) {
                int current = Integer.parseInt(numbers[i]);

                if (current <= prevNumber) {
                    writer.write("NO");
                    return;
                }

                prevNumber = current;
            }

            writer.write("YES");
        }
    }
}
