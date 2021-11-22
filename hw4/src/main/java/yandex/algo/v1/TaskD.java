package yandex.algo.v1;

import java.io.*;
import java.util.Arrays;

public class TaskD {
    private static final String INPUT_FILE_PATH = "input.txt";
    private static final String OUTPUT_FILE_PATH = "output.txt";
    private static final String DELIMITER = " ";

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            int buttonsCounter = Integer.parseInt(reader.readLine());
            int[] buttonsStrength = Arrays.stream(reader.readLine().split(DELIMITER))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            String[] buttonsState = new String[buttonsCounter];
            int clicksCounter = Integer.parseInt(reader.readLine());
            int[] buttonClicks = Arrays.stream(reader.readLine().split(DELIMITER))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int buttonClick : buttonClicks) {
                int buttonIndex = buttonClick - 1;
                int currentStrength = buttonsStrength[buttonIndex] - 1;

                if (currentStrength < 0) {
                    buttonsState[buttonIndex] = "YES";
                } else {
                    buttonsState[buttonIndex] = "NO";
                }

                buttonsStrength[buttonIndex] = currentStrength;
            }

            for (String buttonState : buttonsState) {
                writer.write(buttonState + System.lineSeparator());
            }
        }
    }
}
