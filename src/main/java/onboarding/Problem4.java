package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Problem4 {

    public static HashMap<String, String> map = new HashMap<>();
    public static ArrayList<String> baseWords = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"));

    private static void generateDict() {
        for(int i=0; i< baseWords.size(); i++) {
            map.put(baseWords.get(i), baseWords.get(25-i));
            map.put(baseWords.get(i).toUpperCase(), baseWords.get(25-i).toUpperCase());
        }
    }

    public static String solution(String word) {
        generateDict();

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
