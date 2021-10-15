package pl.dwolkowski.day5;

import pl.dwolkowski.InputFileReader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputFileReader file = new InputFileReader("src/pl/dwolkowski/day5/input.txt");
        List<String> list = file.loadStringList();

        for (String line : list) {
            int index = 0;
            String row = line.substring(0, 7);
            String col = line.substring(7, 10);

            int min = 1;
            int mid = 0;
            int max = 128;

            for (int i = 0; i < row.length(); i++) {
                mid = (min + max) / 2;
                if (row.charAt(i) == 'F')
                    max = mid - 1;
                else if (row.charAt(i) == 'B')
                    min = mid + 1;

                System.out.println("Min: " + min + " | Mid: " + mid + " | Max: " + max);
            }
            index = mid;

            min = 1;
            mid = 0;
            max = 8;

            for (int i = 0; i < col.length(); i++) {
                mid = (min + max) / 2;
                if (row.charAt(i) == 'L')
                    max = mid - 1;
                else if (row.charAt(i) == 'B')
                    min = mid + 1;
            }
            System.out.println(index + " " + mid);
            break;

        }

    }
}
