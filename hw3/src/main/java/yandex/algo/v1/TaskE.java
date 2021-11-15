package yandex.algo.v1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class TaskE {
    private static final String INPUT_FILE_PATH = "input.txt";
    private static final String OUTPUT_FILE_PATH = "output.txt";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            String genome1 = reader.readLine();
            String genome2 = reader.readLine();
            Map<String, Integer> genomeByCounter = new HashMap<>();
            char prevChar1 = genome1.charAt(0);
            int equalsCounter = 0;

            for (int i = 1; i < genome1.length(); i++) {
                char currentChar = genome1.charAt(i);
                String genome = String.valueOf(prevChar1) + currentChar;

                genomeByCounter.compute(genome, (key, value) -> value == null ? 1 : value + 1);
                prevChar1 = currentChar;
            }

            char prevChar2 = genome2.charAt(0);

            for (int i = 1; i < genome2.length(); i++) {
                char currentChar = genome2.charAt(i);
                String genome = String.valueOf(prevChar2) + currentChar;
                int counter = genomeByCounter.getOrDefault(genome, 0);

                if (counter != 0) {
                    genomeByCounter.remove(genome);
                }

                equalsCounter += counter;
                prevChar2 = currentChar;
            }

            writer.write(String.valueOf(equalsCounter));
        }
    }
}
