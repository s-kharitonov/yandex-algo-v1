package yandex.algo.v1;

import java.io.*;

public class TaskC {
    private static final String INPUT_FILE_PATH = "input.txt";
    private static final String OUTPUT_FILE_PATH = "output.txt";
    private static final String DELIMITER = " ";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            int arraySize = Integer.parseInt(reader.readLine());
            String[] arrayElements = reader.readLine()
                    .split(DELIMITER);
            int x = Integer.parseInt(reader.readLine());
            int valueWithMinDistance = Integer.parseInt(arrayElements[0]);
            int minDistance = Math.abs(valueWithMinDistance - x);

            for (int i = 1; i < arrayElements.length; i++) {
                int current = Integer.parseInt(arrayElements[i]);
                int distance = Math.abs(current - x);

                if (distance < minDistance) {
                    minDistance = distance;
                    valueWithMinDistance = current;
                }
            }

            writer.write(String.valueOf(valueWithMinDistance));
        }
    }
}
