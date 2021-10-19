package pl.dwolkowski.day8;

import pl.dwolkowski.InputFileReader;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        InputFileReader file = new InputFileReader("src/pl/dwolkowski/day8/input.txt");

        List<String> list = file.loadStringList();
        Set<Integer> set = new HashSet<>();
        String[] splited;
        int acc = 0;
        int iterator = 0;
        boolean run = true;

        while (run) {
            set.add(iterator);

            splited = list.get(iterator).split(" ");

            switch (splited[0]) {
                case "jmp" -> iterator += Integer.parseInt(splited[1]);
                case "acc" -> {
                    acc += Integer.parseInt(splited[1]);
                    iterator++;
                }
                default -> iterator++;
            }

            if (set.contains(iterator))
                run = false;
        }

        System.out.println(acc);
    }
}
