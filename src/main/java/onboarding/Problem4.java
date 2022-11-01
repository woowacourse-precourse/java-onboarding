package onboarding;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        Map<String, String> map = new HashMap<>();
        map.put(" ", " ");

        for (int i = 0; i < 26; i++) {
            char key = (char) (97 + i);
            char value = (char) (122 - i);

            map.put(String.valueOf(key), String.valueOf(value));
        }

        String copyWord = word;

        if (Pattern.matches("^[a-zA-Z]*$", copyWord.replaceAll(" ", ""))) {
            String[] wordArr = word.split("");
            String[] answerArr = new String[wordArr.length];

            setAnswerArr(map, wordArr, answerArr);

            answer = String.join("", answerArr);
        }
        
        return answer;
    }

    private static void setAnswerArr(Map<String, String> map, String[] wordArr, String[] answerArr) {
        for (int i = 0; i < wordArr.length; i++) {
            if (Character.isUpperCase(wordArr[i].charAt(0))) {
                answerArr[i] = map.get(wordArr[i].toLowerCase()).toUpperCase();
            } else {
                answerArr[i] = map.get(wordArr[i]);
            }
        }
    }
}
