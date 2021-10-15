package pl.dwolkowski.day2;

import pl.dwolkowski.InputFileReader;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        InputFileReader file = new InputFileReader("src/pl/dwolkowski/day2/input.txt");
        List<String> list = file.loadStringList();
        int resultA = 0;
        int resultB = 0;

        for (String line : list) {

            String[] splitted = line.split(" ");
            String[] range = splitted[0].split("-");

            char letter = splitted[1].charAt(0);
            int min = Integer.parseInt(range[0]);
            int max = Integer.parseInt(range[1]);
            int numberOfLetters = 0;

            // Part 1
            for (int i = 0; i < splitted[2].length(); i++) {
                if (splitted[2].charAt(i) == letter) {
                    numberOfLetters++;
                }
            }

            if (numberOfLetters >= min)
                if (numberOfLetters <= max)
                    resultA++;

            // Part 2

            if (max - 1 > splitted[2].length()) {
                if (splitted[2].charAt(min - 1) == letter)
                    resultB++;
            } else if (splitted[2].charAt(min - 1) == letter || splitted[2].charAt(max - 1) == letter)
                if (splitted[2].charAt(min - 1) != splitted[2].charAt(max - 1))
                    resultB++;

        }

        System.out.println(resultA);
        System.out.println(resultB);
    }
}
