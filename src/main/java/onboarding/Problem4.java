package onboarding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        Map<String, String> lowerAlphabetHashMap = new HashMap<>();
        Map<String, String> upperAlphabetHashMap = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            String lowerAlphabetKey = Character.toString((char)((int)'a' + i));
            String upperAlphabetKey = Character.toString((char)((int)'A' + i));
            String lowerAlphabetValue = Character.toString((char)((int)'z' + i));
            String upperAlphabetValue = Character.toString((char)((int)'Z' + i));

            lowerAlphabetHashMap.put(lowerAlphabetKey, lowerAlphabetValue);
            upperAlphabetHashMap.put(upperAlphabetKey, upperAlphabetValue);
        }

        String answer = "";
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (Character.isUpperCase(letter)) {
                String key = Character.toString(letter);
                answer += upperAlphabetHashMap.get(key);
            } else if (Character.isLowerCase(letter)) {
                String key = Character.toString(letter);
                answer += lowerAlphabetHashMap.get(key);
            } else {
                answer += letter;
            }

        }




//        String[] upperAlphabets = new String[26];
//        String[] lowerAlphabets = new String[26];
//        String[] reverseUpperAlphabets = new String[26];
//        String[] reverseLowerAlphabets = new String[26];
//
//        for (int i = 0; i < 26; i++) {
//            upperAlphabets[i] = Character.toString((char)((int)'A' + i));
//            lowerAlphabets[i] = Character.toString((char)((int)'a' + i));
//            reverseUpperAlphabets[i] = Character.toString((char) ((int)'Z' - i));
//            reverseLowerAlphabets[i] = Character.toString((char) ((int)'z' - i));
//        }
//
//        String answer = "";
//        for (int i = 0; i < word.length(); i++) {
//            char letter = word.charAt(i);
//            if (Character.isUpperCase(letter)) {
//                int index = Arrays.asList(upperAlphabets).indexOf(Character.toString(letter));
//                answer += reverseUpperAlphabets[index];
//            } else if (Character.isLowerCase(letter)) {
//                int index = Arrays.asList(lowerAlphabets).indexOf(Character.toString(letter));
//                answer += reverseLowerAlphabets[index];
//            } else {
//                answer += letter;
//            }
//
//        }

        return answer;
    }
}
