package pl.dwolkowski.day4;

import pl.dwolkowski.InputFileReader;
import pl.dwolkowski.day4.validator.Validator;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        InputFileReader file = new InputFileReader("src/pl/dwolkowski/day4/input.txt");
        List<String> list = file.loadStringList();
        Map<String, String> map = new HashMap<>();

        Validator validator = new Validator();

        int correctPassports = 0;

        for (String line : list) {
            if (line.equals("")) {
                if(validator.checkPassportExtra(map))
                    correctPassports++;
                map.clear();
                continue;
            }

            String[] parts = line.split(" ");
            for (String part : parts) {
                if (part.length() == 0)
                    continue;
                String[] x = part.split(":");
                map.put(x[0], x[1]);
            }
        }

        System.out.println(correctPassports);

    }

}
