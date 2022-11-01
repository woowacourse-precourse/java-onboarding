package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        String[] array_word;
        String[] change_word = {"Z","Y","X","W","V","U","T","S","R","Q","P","O","N","M","L","K","J","I","H","G","F","E","D","C","B","A" };

        Map<String, String> alpha = new HashMap<>();

        char[] alphabet = new char[26];

        for (int i = 0; i < alphabet.length; i++) {
            alpha.put(Character.toString((char)('A'+ i)), change_word[i]);
        }

        array_word = word.split("");

        for (String c_word : array_word) {
            boolean is_up = Character.isUpperCase(c_word.charAt(0));

            String temp_result = alpha.get(c_word.toUpperCase());
            if (temp_result == null) {
                temp_result = " ";
            } else if (!is_up) {
                temp_result = temp_result.toLowerCase();
            }
            answer = temp_result.concat(temp_result);
        }

        return answer;
    }
}
