package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Problem4 {
    public static HashMap<String, String> map = new HashMap<>();
    public static ArrayList<String> baseWords = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"));
    public static ArrayList<String> keyList = new ArrayList<>();
    public static ArrayList<String> valueList = new ArrayList<>();

    Problem4() {
        addWordsToValueList();
        addWordsToKeyList();
        generateDict();
    }

    private static void addWordsToValueList() {
        for (String s: baseWords) {
            valueList.add(s.toUpperCase());
        }
        for (String s: baseWords) {
            valueList.add(s);
        }
        Collections.reverse(valueList);
    }

    private static void addWordsToKeyList() {
        for (String s : baseWords) {
            keyList.add(s);
        }
        for (String s : baseWords) {
            keyList.add(s.toUpperCase());
        }
    }



    private static void generateDict() {
        for (int i=0; i<keyList.size(); i++) {
            map.put(keyList.get(i), valueList.get(i));
        }
    }

    public static String solution(String word) {
        Problem4 problem4 = new Problem4();
        String convertedString = "";
        for (int i=0; i< word.length(); i++) {
            String targetString = String.valueOf(word.charAt(i));
            if (map.containsKey(targetString)) {
                targetString = map.get(targetString);
            }
            convertedString += targetString;
        }
        return convertedString;
    }
}
