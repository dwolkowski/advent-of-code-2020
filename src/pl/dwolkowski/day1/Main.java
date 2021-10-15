package pl.dwolkowski.day1;

import pl.dwolkowski.InputFileReader;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        InputFileReader file = new InputFileReader("src/pl/dwolkowski/day1/input.txt");
        List list = file.loadIntegerList();

        // Part 1
        System.out.println(answerPartOne(list));

        // Part 2
        System.out.println(answerPartTwo(list));

    }

    // O(n^2)
    private static int answerPartOne(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++)
                if (i != j)
                    if (list.get(i) + list.get(j) == 2020)
                        return list.get(i) * list.get(j);
        }

        // If there's no right answer returns 0
        return 0;
    }

    // O(n^3)
    private static int answerPartTwo(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++)
                if (i != j)
                    for (int k = 0; k < list.size(); k++)
                        if (j != k)
                            if (i != k)
                                if (list.get(i) + list.get(j) + list.get(k) == 2020)
                                    return list.get(i) * list.get(j) * list.get(k);
        }

        // If there's no right answer returns 0
        return 0;
    }

}
