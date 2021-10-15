package pl.dwolkowski;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InputFileReader {
    private BufferedReader reader;

    public InputFileReader(String path) {
        try {
            reader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist.");
        }
    }

    public List<Integer> loadIntegerList() {
        if (reader == null)
            return new ArrayList<Integer>();
        return reader.lines().map(Integer::parseInt).collect(Collectors.toList());
    }

    public List<String> loadStringList() {
        if (reader == null)
            return new ArrayList<String>();
        return reader.lines().collect(Collectors.toList());
    }

/*
    Universal method returning List of String or Integer but can throw NullPointerException
      and it's unsafe because uses Object as Type of List.

    public List<Object> loadList(Class<T> outputClass){
        if(reader==null)
            return null;
        if(outputClass.equals(Integer.class)){
            try{
                return reader.lines().map(Integer::parseInt).collect(Collectors.toList());
            }catch (NumberFormatException e){
                System.out.println("Can't parse to Integer.");
                return null;
            }
        }
        if(outputClass.equals(String.class))
            return reader.lines().collect(Collectors.toList());
        else
            return null;
    }

*/

}
