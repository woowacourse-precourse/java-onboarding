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

        // Character.toString을 사용하여 java에서 ASCII를 Char로 변환
        for (int i = 0; i < alpabat.length; i++) {
            dic.put(Character.toString((char)('A' + i)), reverseArray[i] );
        }

        // 한 글자씩 배열에 넣는다
        questionArray = word.split("");

        for(String changeWord : questionArray) {

            boolean uppLow = Character.isUpperCase(changeWord.charAt(0));

            String result = dic.get(changeWord.toUpperCase());
            if (result == null) {
                result =" ";
            } else if (!uppLow) {
                result = result.toLowerCase();
            }

            // 문자열 합치기 concat()
            answer = answer.concat(result);
        }
        return answer;
    }
}
