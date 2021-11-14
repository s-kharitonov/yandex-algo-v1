package yandex.algo.v1;

import java.io.*;

public class TaskB {
    private static final String INPUT_FILE_PATH = "input.txt";
    private static final String OUTPUT_FILE_PATH = "output.txt";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            String[] numbers = reader.lines()
                    .toArray(String[]::new);
            int prev = Integer.parseInt(numbers[0]);
            SortType type = null;

            for (int i = 1; i < numbers.length - 1; i++) {
                int current = Integer.parseInt(numbers[i]);

                if (current == prev) {
                    if (type == null) {
                        type = SortType.CONSTANT;
                    } else if (type == SortType.ASCENDING) {
                        type = SortType.WEAKLY_ASCENDING;
                    } else if (type == SortType.DESCENDING) {
                        type = SortType.WEAKLY_DESCENDING;
                    }
                } else if (current > prev) {
                    if (type == null) {
                        type = SortType.ASCENDING;
                    } else if (type == SortType.WEAKLY_DESCENDING || type == SortType.DESCENDING) {
                        type = SortType.RANDOM;
                    } else if (type == SortType.CONSTANT) {
                        type = SortType.WEAKLY_ASCENDING;
                    }
                } else {
                    if (type == null) {
                        type = SortType.DESCENDING;
                    } else if (type == SortType.WEAKLY_ASCENDING || type == SortType.ASCENDING) {
                        type = SortType.RANDOM;
                    } else if (type == SortType.CONSTANT) {
                        type = SortType.WEAKLY_DESCENDING;
                    }
                }

                prev = current;
            }

            writer.write(type.getName());
        }
    }

    private enum SortType {
        CONSTANT("CONSTANT"),
        DESCENDING("DESCENDING"),
        ASCENDING("ASCENDING"),
        WEAKLY_ASCENDING("WEAKLY ASCENDING"),
        WEAKLY_DESCENDING("WEAKLY DESCENDING"),
        RANDOM("RANDOM");

        private final String name;

        SortType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
