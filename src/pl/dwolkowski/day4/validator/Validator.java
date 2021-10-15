package pl.dwolkowski.day4.validator;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Validator {

    // Part 1
    public boolean checkPassport(Map<String, String> map) {
        List<String> correctKeys = Arrays.asList("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid");
        for (String correctKey : correctKeys) {
            if (!map.containsKey(correctKey))
                return false;
        }
        return true;
    }

    // Part 2
    public boolean checkPassportExtra(Map<String, String> map) {
        if (!checkPassport(map))
            return false;

        // byr BETWEEN [1920;2002]
        if (!isBetween(1920, 2002, Integer.parseInt(map.get("byr"))))
            return false;

        // iyr BETWEEN [2010;2020]
        if (!isBetween(2010, 2020, Integer.parseInt(map.get("iyr"))))
            return false;

        // eyr BETWEEN [2020;2030]
        if (!isBetween(2020, 2030, Integer.parseInt(map.get("eyr"))))
            return false;

        if (!hgtCheck(map.get("hgt")))
            return false;

        if (!hclCheck(map.get("hcl")))
            return false;

        if (!eclCheck(map.get("ecl")))
            return false;

        if (!pidCheck(map.get("pid")))
            return false;

        return true;
    }

    private boolean isBetween(int min, int max, int value) {
        if(value < min || value > max)
            return false;

        return true;
    }

    // hgt BETWEEN [150;193]cm OR BETWEEN [59;76]in
    private boolean hgtCheck(String value) {
        if (value.contains("cm")) {
            value = value.replaceAll("[^0-9]", "");
            if (Integer.parseInt(value) < 150 || Integer.parseInt(value) > 193)
                return false;
        } else if (value.contains("in")) {
            value = value.replaceAll("[^0-9]", "");
            if (Integer.parseInt(value) < 59 || Integer.parseInt(value) > 76)
                return false;
        } else
            return false;

        return true;
    }

    // hcl starts with # and between 0-9 and a-f MAX 6 characters
    private boolean hclCheck(String value) {
        if (value.charAt(0) != '#')
            return false;
        value = value.substring(1);
        if (Pattern.matches("[0-9a-f]", value))
            return false;

        return true;
    }

    // ecl contains amb, blu, brn, gry, grn, hzl, oth
    private boolean eclCheck(String value) {
        List<String> eclList = Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth");
        boolean found = false;
        for (String type : eclList) {
            if (type.equals(value)) {
                found = true;
                break;
            }
        }
        if (!found)
            return false;

        return true;
    }

    // pid nine numbers including leading zeroes
    private boolean pidCheck(String value) {
        if (Pattern.matches("[0-9]", value))
            return false;
        if (value.length() != 9)
            return false;

        return true;
    }
}
