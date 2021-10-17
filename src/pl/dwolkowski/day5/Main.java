package pl.dwolkowski.day5;

import pl.dwolkowski.InputFileReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputFileReader file = new InputFileReader("src/pl/dwolkowski/day5/input.txt");
        List<String> list = file.loadStringList();
        List<Integer> seatIds = new ArrayList<>();

        // Part 1
        for (String line : list) {
            int minRow = 0, maxRow = 127;
            int minCol = 0, maxCol = 7;

            for (char c : line.toCharArray()) {
                switch (c) {
                    case 'F' -> maxRow = (maxRow - minRow) / 2 + minRow;
                    case 'B' -> minRow = (maxRow - minRow) / 2 + minRow + 1;
                    case 'L' -> maxCol = (maxCol - minCol) / 2 + minCol;
                    case 'R' -> minCol = (maxCol - minCol) / 2 + minCol + 1;
                }
            }
            seatIds.add((minRow * 8) + minCol);
        }
        Collections.sort(seatIds);
        System.out.println(seatIds.get(seatIds.size()-1));

        // Part 2
        int recentSeat = seatIds.get(0);
        seatIds.remove(0);
        for (int id : seatIds) {
            if (id != (recentSeat + 1)) {
                System.out.println(recentSeat+1);
                break;
            }
            recentSeat = id;
        }

    }
}
