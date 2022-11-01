package onboarding;

import java.util.HashMap;
import java.util.Map;
public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        String[] questionArray;
        String[] reverseArray = {"Z", "Y", "X", "W", "V", "U", "T", "S",
                "R", "Q", "P", "O", "N", "M", "L", "K", "J", "I",
                "H", "G", "F", "E", "D", "C", "B", "A"};

        Map<String, String> dic = new HashMap<>();

        char[] alpabat = new char[26];

        for (int i = 0; i < alpabat.length; i++) {
            dic.put(Character.toString((char)('A' + i)), reverseArray[i] );
        }

        questionArray = word.split("");

        for(String changeWord : questionArray) {

            boolean uppLow = Character.isUpperCase(changeWord.charAt(0));

            String result = dic.get(changeWord.toUpperCase());
            if (result == null) {
                result =" ";
            } else if (!uppLow) {
                result = result.toLowerCase();
            }

            answer = answer.concat(result);
        }
        return answer;
    }
}
