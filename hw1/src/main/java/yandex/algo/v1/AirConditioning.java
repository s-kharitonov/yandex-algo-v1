package yandex.algo.v1;

import java.io.*;

public class AirConditioning {

    private static final String INPUT_FILE_PATH = "input.txt";
    private static final String OUTPUT_FILE_PATH = "output.txt";
    private static final String DELIMITER = " ";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            String[] temperature = reader.readLine().split(DELIMITER);
            String mode = reader.readLine();
            int from = Integer.parseInt(temperature[0]);
            int to = Integer.parseInt(temperature[1]);

            switch (mode) {
                case "freeze":
                    if (from > to) {
                        writer.write(String.valueOf(to));
                    } else {
                        writer.write(String.valueOf(from));
                    }
                    break;
                case "heat":
                    if (from < to) {
                        writer.write(String.valueOf(to));
                    } else {
                        writer.write(String.valueOf(from));
                    }
                    break;
                case "auto":
                    writer.write(String.valueOf(to));
                    break;
                case "fan":
                    writer.write(String.valueOf(from));
                    break;
                default:
                    throw new IllegalArgumentException("not valid mode");
            }
        }
    }
}
