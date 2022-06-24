package com.terzeron.functional;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Words {
    private Set<String> NON_WORDS =
            new HashSet<String>() {{
                add("the");
                add("and");
                add("of");
                add("to");
                add("a");
                add("i");
                add("it");
                add("in");
                add("or");
                add("is");
                add("d");
                add("s");
                add("as");
                add("so");
                add("but");
                add("be");
            }};

    public Map wordFreq(String words) {
        TreeMap<String, Integer> wordMap = new TreeMap<String, Integer>();
        Matcher m = Pattern.compile("\\w+").matcher(words);
        while (m.find()) {
            String word = m.group().toLowerCase();
            if (!NON_WORDS.contains(word)) {
                if (wordMap.get(word) == null) {
                    wordMap.put(word, 1);
                } else {
                    wordMap.put(word, wordMap.get(word) + 1);
                }
            }
        }
        return wordMap;
    }

   private List<String> regexToList(String words, String regex) {
        List wordList = new ArrayList<>();
        Matcher m = Pattern.compile(regex).matcher(words);
        while (m.find())
            wordList.add(m.group());
        return wordList;
    }

    public Map wordFreqByStream(String words) {
        TreeMap<String, Integer> wordMap = new TreeMap<>();
        regexToList(words, "\\w+").stream()
                .map(w -> w.toLowerCase())
                .filter(w -> !NON_WORDS.contains(w))
                .forEach(w -> wordMap.put(w, wordMap.getOrDefault(w, 0) + 1));
        return wordMap;
    }

    public static void main(String[] args) {
        Words words = new Words();

        Map<String, Integer> wordMap1 = words.wordFreq("i am a new pilot pilot drive the airplane do you want to " +
                "drive" +
                " this airplane this airplane flies well");
        for (String word : wordMap1.keySet()) {
            System.out.println(word + ": " + wordMap1.get(word));
        }
        Map<String, Integer> wordMap2 = words.wordFreqByStream("i am a new pilot pilot drive the airplane do you want to " +
                "drive" +
                " this airplane this airplane flies well");
        for (String word : wordMap2.keySet()) {
            System.out.println(word + ": " + wordMap2.get(word));
        }
    }

}
