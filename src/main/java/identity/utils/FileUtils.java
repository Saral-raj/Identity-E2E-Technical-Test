package identity.utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileUtils {
    public static boolean fileExists(String fileName) {
        return Files.exists(Paths.get(fileName));
    }

    public static List<String> extractRegistrationNumbers(String InputFile) {
        List<String> regNumbers = new ArrayList<>();
        String regex = "\\b[A-Z]{2}\\d{2}\\s?[A-Z]{3}\\b";

        try {
            List<String> lines = Files.readAllLines(Paths.get(InputFile));
            Pattern pattern = Pattern.compile(regex);

            for (String line : lines) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    regNumbers.add(matcher.group());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return regNumbers;
    }

    public static boolean compareOutputs(Map<String,Map<String,String>> actualOutput, String ExpectedOutputFile) {
        try {
            List<String> expectedLines = Files.readAllLines(Paths.get(ExpectedOutputFile));

            for (String expectedLine : expectedLines) {
                String[] parts = expectedLine.split(",");
                String regNumber = parts[0];
                String expectedDetails = String.join(",", Arrays.copyOfRange(parts, 1, parts.length));

                if (!actualOutput.containsKey(regNumber) || !actualOutput.get(regNumber).equals(expectedDetails)) {
                    return false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
