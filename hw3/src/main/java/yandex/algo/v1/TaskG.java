package yandex.algo.v1;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class TaskG {
    private static final String INPUT_FILE_PATH = "input.txt";
    private static final String OUTPUT_FILE_PATH = "output.txt";
    private static final String DELIMITER = " ";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            int turtleCount = Integer.parseInt(reader.readLine());
            Set<String> answers = new HashSet<>();

            for (int i = 0; i < turtleCount; i++) {
                String answer = reader.readLine();

                if (answers.contains(answer)) {
                    continue;
                }

                String[] splitAnswer = answer.split(DELIMITER);
                int head = Integer.parseInt(splitAnswer[0]);
                int tail = Integer.parseInt(splitAnswer[1]);
                int turtleAnswer = head + tail;
                int turtleCountWithoutCurrent = turtleCount - 1;

                if (turtleAnswer == turtleCountWithoutCurrent && head >= 0 && tail >= 0) {
                    answers.add(answer);
                }

            }

            writer.write(String.valueOf(answers.size()));
        }
    }
}
