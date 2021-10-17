package pl.dwolkowski.day6;

import pl.dwolkowski.InputFileReader;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        InputFileReader file = new InputFileReader("src/pl/dwolkowski/day6/input.txt");
        List<String> list = file.loadStringList();

        // Part 1
        Set<Character> set = new HashSet<>();
        int sum = 0;

        for (String line : list) {

            if (line.equals("")) {
                set.clear();
                continue;
            }

            for (char c : line.toCharArray()) {
                if (!set.contains(c)) {
                    set.add(c);
                    sum++;
                }
            }
        }

        System.out.println(sum);

        // Part 2
        Map<Character, Integer> map = new HashMap<>();
        sum = 0;

        int persons = 0;
        for (String line : list) {

            if (line.equals("")) {
                sum += getSum(map, persons);
                map.clear();
                persons = 0;
                continue;
            }

            for (char c : line.toCharArray()) {
                if (!map.containsKey(c))
                    map.put(c, 1);
                else
                    map.put(c, map.get(c) + 1);
            }
            persons++;
        }
        // We need to check last group
        sum += getSum(map, persons);

        System.out.println(sum);
    }

    private static int getSum(Map<Character, Integer> map, int persons) {
        int sum = 0;
        if (map.containsValue(persons)) {
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue().equals(persons)) {
                    sum++;
                }
            }
        }
        return sum;
    }


}

