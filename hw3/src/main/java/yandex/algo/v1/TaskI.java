package yandex.algo.v1;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class TaskI {
    private static final String INPUT_FILE_PATH = "input.txt";
    private static final String OUTPUT_FILE_PATH = "output.txt";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new FileReader(INPUT_FILE_PATH));
             var writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            int schoolBoysCount = Integer.parseInt(reader.readLine());
            Set<String> languagesUnion = new HashSet<>();
            Set<String> languagesIntersection = new HashSet<>();

            for (int i = 0; i < schoolBoysCount; i++) {
                int languagesCount = Integer.parseInt(reader.readLine());
                Set<String> languages = new HashSet<>();

                for (int j = 0; j < languagesCount; j++) {
                    String language = reader.readLine();

                    languagesUnion.add(language);
                    languages.add(language);
                }

                if (i == 0) {
                    languagesIntersection = new HashSet<>(languages);
                    continue;
                }

                languagesIntersection.retainAll(languages);
            }

            writer.write(languagesIntersection.size() + LINE_SEPARATOR);
            writer.write(joinLanguages(languagesIntersection));
            writer.write(languagesUnion.size() + LINE_SEPARATOR);
            writer.write(joinLanguages(languagesUnion));
        }
    }

    private static String joinLanguages(Set<String> languages) {
        if (languages.isEmpty()) {
            return "";
        }

        return String.join(LINE_SEPARATOR, languages) + LINE_SEPARATOR;
    }
}
