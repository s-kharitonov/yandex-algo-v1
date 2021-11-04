package yandex.algo.v1;

import java.io.*;

public class Triangle {
    private static final String INPUT_FILE_PATH = "input.txt";
    private static final String OUTPUT_FILE_PATH = "output.txt";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            int a = Integer.parseInt(reader.readLine());
            int b = Integer.parseInt(reader.readLine());
            int c = Integer.parseInt(reader.readLine());

            if (sum(a, b) > c && sum(a, c) > b && sum(b, c) > a) {
                writer.write("YES");
            } else {
                writer.write("NO");
            }
        }
    }

    private static int sum(int a, int b) {
        return a + b;
    }
}
