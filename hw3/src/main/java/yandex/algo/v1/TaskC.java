package yandex.algo.v1;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

import static java.util.stream.Collectors.joining;

public class TaskC {
    private static final String INPUT_FILE_PATH = "input.txt";
    private static final String OUTPUT_FILE_PATH = "output.txt";
    private static final String DELIMITER = " ";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            String[] cubeCounters = reader.readLine()
                    .split(DELIMITER);
            int cubesCounter1 = Integer.parseInt(cubeCounters[0]);
            int cubesCounter2 = Integer.parseInt(cubeCounters[1]);
            Set<Integer> cubes1 = new TreeSet<>();
            Set<Integer> cubes2 = new TreeSet<>();

            for (int i = 0; i < cubesCounter1; i++) {
                cubes1.add(Integer.parseInt(reader.readLine()));
            }

            for (int i = 0; i < cubesCounter2; i++) {
                cubes2.add(Integer.parseInt(reader.readLine()));
            }

            Set<Integer> disjunction = new TreeSet<>(cubes1);

            disjunction.retainAll(cubes2);
            cubes1.removeAll(disjunction);
            cubes2.removeAll(disjunction);

            writer.write(disjunction.size() + LINE_SEPARATOR);
            writer.write(joinSequence(disjunction) + LINE_SEPARATOR);
            writer.write(cubes1.size() + LINE_SEPARATOR);
            writer.write(joinSequence(cubes1) + LINE_SEPARATOR);
            writer.write(cubes2.size() + LINE_SEPARATOR);
            writer.write(joinSequence(cubes2));
        }
    }

    private static String joinSequence(Set<Integer> sequence) {
        if (sequence.isEmpty()) {
            return "";
        }

        return sequence.stream()
                .map(String::valueOf)
                .collect(joining(DELIMITER));
    }
}
