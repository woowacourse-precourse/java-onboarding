package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {

    private static String getReverseWord(String momWord) {

        char[] alpabat = new char[26];
        String finalResult = "";
        String[] momWordArray = momWord.split("");
        String[] standardArray = {"Z", "Y", "X", "W", "V", "U", "T", "S", "R", "Q", "P", "O", "N", "M", "L", "K", "J", "I", "H", "G", "F", "E", "D", "C", "B", "A"};

        Map<String, String> tmp = new HashMap<>();


        for(int i = 0; i< alpabat.length; i++) {
            tmp.put(Character.toString((char) (i + 'A')), standardArray[i]);
        }

        for(String word : momWordArray) {
            boolean isUpperLetter = Character.isUpperCase(word.charAt(0));

            String tmpValue = tmp.get(word.toUpperCase());

            if(tmpValue == null) {
                tmpValue = " ";
            }
            else if(!isUpperLetter) {
                tmpValue = tmpValue.toLowerCase();
            }

            finalResult = finalResult.concat(tmpValue);

        }
        return finalResult;

    }

    public static String solution(String word) {
        String answer = getReverseWord(word);
        return answer;
    }
}
