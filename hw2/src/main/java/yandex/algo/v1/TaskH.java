package yandex.algo.v1;

import java.io.*;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class TaskH {
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
            int third = Integer.parseInt(numbers[2]);
            int positiveMax1 = max(first, max(second, third));
            int positiveMax2 = middle(first, second, third);
            int positiveMax3 = min(first, min(second, third));
            int negativeMin1 = positiveMax2;
            int negativeMin2 = positiveMax3;

            for (int i = 3; i < numbers.length; i++) {
                int current = Integer.parseInt(numbers[i]);

                if (current > positiveMax1) {
                    positiveMax3 = positiveMax2;
                    positiveMax2 = positiveMax1;
                    positiveMax1 = current;
                    continue;
                }

                if (current > positiveMax2) {
                    positiveMax3 = positiveMax2;
                    positiveMax2 = current;
                    continue;
                }

                if (current > positiveMax3) {
                    positiveMax3 = current;
                    continue;
                }

                if (current < negativeMin2) {
                    negativeMin1 = negativeMin2;
                    negativeMin2 = current;
                    continue;
                }

                if (current < negativeMin1) {
                    negativeMin1 = current;
                }
            }

            long positiveRes = (long) positiveMax1 * positiveMax2 * positiveMax3;
            long negativeRes = (long) positiveMax1 * negativeMin1 * negativeMin2;

            if (positiveRes > negativeRes) {
                writer.write(positiveMax1 + DELIMITER + positiveMax2 + DELIMITER + positiveMax3);
            } else {
                writer.write(positiveMax1 + DELIMITER + negativeMin1 + DELIMITER + negativeMin2);
            }
        }
    }

    private static int middle(int first, int second, int third) {
        int x = first - second;
        int y = second - third;
        int z = first - third;

        if (x * y > 0) {
            return second;
        }

        if (x * z > 0) {
            return third;
        }

        return first;
    }
}
