package pl.dwolkowski.day3;

import pl.dwolkowski.InputFileReader;

import java.util.List;

public class
Main {
    public static void main(String[] args) {

        // Part 1
        countTrees(3, 1);

        countTrees(1, 1);
        countTrees(5, 1);
        countTrees(7, 1);
        countTrees(1, 2);

        System.out.println("Part 2 = " + 209 * 58 * 58 * 64 * 35);
    }

    public static void countTrees(int indexesToSkip, int rowsToSkip) {
        InputFileReader file = new InputFileReader("src/pl/dwolkowski/day3/input.txt");
        List<String> list = file.loadStringList();

        // Deleting first row because we will never use it
        list.remove(0);

        if (rowsToSkip < 1) {
            System.out.println("Amount of rows to jump per iteration cannot be lower than 1");
            return;
        }

        int indexControler = 0;
        int rowControler = 0;
        int trees = 0;

        for (String line : list) {
            rowControler++;

            // Moving row
            if (rowControler % rowsToSkip != 0)
                continue;

            // Moving index
            for (int q = 0; q < indexesToSkip; q++) {
                if (indexControler + 1 > line.length() - 1)
                    indexControler = 0;
                else
                    indexControler++;
            }

            // Checking if it's tree
            if (line.charAt(indexControler) == '#')
                trees++;

        }

        System.out.println("Amount of trees: " + trees);
    }
}

