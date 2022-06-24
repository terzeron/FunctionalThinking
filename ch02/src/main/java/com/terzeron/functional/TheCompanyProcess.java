package com.terzeron.functional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TheCompanyProcess {
    public String cleanNames(List<String> listOfNames) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < listOfNames.size(); i++) {
            System.out.println(listOfNames.get(i));
            if (listOfNames.get(i).length() > 1) {
                result.append(capitalizeString(listOfNames.get(i))).append(",");
            }
        }
        return result.substring(0, result.length() - 1);
    }

    public String capitalizeString(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1, s.length());
    }

    public String cleanNamesByStream(List<String> names) {
        if (names == null) return "";
        return names.stream()
                .filter(name -> name.length() > 1)
                .map(name -> capitalize(name))
                .collect(Collectors.joining(","));
    }

    private String capitalize(String e) {
        return e.substring(0, 1).toUpperCase() + e.substring(1, e.length());
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("michael jackson", "John smith", "paul brown");
        TheCompanyProcess process = new TheCompanyProcess();
        System.out.println(process.cleanNames(names));

        System.out.println(process.cleanNamesByStream(names));
    }

}
