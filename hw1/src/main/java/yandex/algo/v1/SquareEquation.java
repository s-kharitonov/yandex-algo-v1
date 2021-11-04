package yandex.algo.v1;

import java.io.*;

public class SquareEquation {
    private static final String INPUT_FILE_PATH = "input.txt";
    private static final String OUTPUT_FILE_PATH = "output.txt";
    private static final String NO_SOLUTION_TEXT = "NO SOLUTION";
    private static final String MANY_SOLUTIONS_TEXT = "MANY SOLUTIONS";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            int a = Integer.parseInt(reader.readLine());
            int b = Integer.parseInt(reader.readLine());
            int c = Integer.parseInt(reader.readLine());
            int sqrtC = c * c;

            if (a == 0 && b == sqrtC) {
                writer.write(MANY_SOLUTIONS_TEXT);
                return;
            }

            if (a == 0) {
                writer.write(NO_SOLUTION_TEXT);
                return;
            }

            if (c < 0) {
                writer.write(NO_SOLUTION_TEXT);
                return;
            }

            double res = (sqrtC - b) / (double)a;

            if ((int) res == res) {
                writer.write(String.valueOf((int)res));
            } else {
                writer.write(NO_SOLUTION_TEXT);
            }
        }

    }
}
