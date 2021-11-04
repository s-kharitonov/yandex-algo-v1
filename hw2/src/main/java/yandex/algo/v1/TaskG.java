package yandex.algo.v1;

import java.io.*;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class TaskG {
    private static final String INPUT_FILE_PATH = "input.txt";
    private static final String OUTPUT_FILE_PATH = "output.txt";
    private static final String DELIMITER = " ";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            String[] numbers = reader.readLine()
                    .split(DELIMITER);
            int first = Integer.parseInt(numbers[0]);
            int second = Integer.parseInt(numbers[1]);
            int positiveMax1 = max(first, second);
            int positiveMax2 = min(first, second);
            int negativeMax1 = positiveMax1;
            int negativeMax2 = positiveMax2;

            for (int i = 2; i < numbers.length; i++) {
                int current = Integer.parseInt(numbers[i]);

                if (current > positiveMax1) {
                    positiveMax2 = positiveMax1;
                    positiveMax1 = current;
                    continue;
                }

                if (current > positiveMax2) {
                    positiveMax2 = current;
                    continue;
                }

                if (current < negativeMax2) {
                    negativeMax1 = negativeMax2;
                    negativeMax2 = current;
                    continue;
                }

                if (current < negativeMax1) {
                    negativeMax1 = current;
                }
            }

            long positiveRes = (long) positiveMax1 * positiveMax2;
            long negativeRes = (long) negativeMax1 * negativeMax2;

            if (positiveRes > negativeRes) {
                writer.write(positiveMax2 + DELIMITER + positiveMax1);
            } else {
                writer.write(negativeMax2 + DELIMITER + negativeMax1);
            }
        }
    }
}
