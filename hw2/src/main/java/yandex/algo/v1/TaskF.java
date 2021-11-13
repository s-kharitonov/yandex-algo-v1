package yandex.algo.v1;

import java.io.*;
import java.util.Arrays;
import java.util.StringJoiner;

public class TaskF {
    private static final String INPUT_FILE_PATH = "input.txt";
    private static final String OUTPUT_FILE_PATH = "output.txt";
    private static final String DELIMITER = " ";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            int sequenceSize = Integer.parseInt(reader.readLine());
            String[] sequence = reader.readLine()
                    .split(DELIMITER);
            String[] tail = null;

            for (int i = 0; i < sequence.length; i++) {
                String[] sequenceSlice = Arrays.copyOfRange(sequence, i, sequence.length);

                if (isSymmetric(sequenceSlice)) {
                    tail = Arrays.copyOfRange(sequence, 0, i);
                    break;
                }
            }

            if (tail == null) {
                writer.write("0");
            } else {
                writer.write(tail.length + System.lineSeparator());
                writer.write(concatSequence(tail));
            }
        }
    }

    private static boolean isSymmetric(String[] sequence) {
        for (int headIndex = 0, tailIndex = sequence.length - 1; headIndex < sequence.length;
             headIndex++, tailIndex--) {
            int current = Integer.parseInt(sequence[headIndex]);
            int pairForCurrent = Integer.parseInt(sequence[tailIndex]);

            if (current != pairForCurrent) {
               return false;
            }
        }
        
        return true;
    }

    private static String concatSequence(String[] sequence) {
        StringJoiner joiner = new StringJoiner(DELIMITER);

        for (int i = sequence.length - 1; i >= 0; i--) {
            joiner.add(sequence[i]);
        }

        return joiner.toString();
    }
}
