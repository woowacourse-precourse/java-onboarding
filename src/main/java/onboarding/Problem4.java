package onboarding;


import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        // 청개구리 사전 구현
        Map<String, String> treeFrogDictionary = new HashMap<>();
        treeFrogDictionary.put("A", "Z");
        treeFrogDictionary.put("B", "Y");
        treeFrogDictionary.put("C", "X");
        treeFrogDictionary.put("D", "W");
        treeFrogDictionary.put("E", "V");
        treeFrogDictionary.put("F", "U");
        treeFrogDictionary.put("G", "T");
        treeFrogDictionary.put("H", "S");
        treeFrogDictionary.put("I", "R");
        treeFrogDictionary.put("J", "Q");
        treeFrogDictionary.put("K", "P");
        treeFrogDictionary.put("L", "O");
        treeFrogDictionary.put("M", "N");
        treeFrogDictionary.put("N", "M");
        treeFrogDictionary.put("O", "L");
        treeFrogDictionary.put("P", "K");
        treeFrogDictionary.put("Q", "J");
        treeFrogDictionary.put("R", "I");
        treeFrogDictionary.put("S", "H");
        treeFrogDictionary.put("T", "G");
        treeFrogDictionary.put("U", "F");
        treeFrogDictionary.put("V", "E");
        treeFrogDictionary.put("W", "D");
        treeFrogDictionary.put("X", "C");
        treeFrogDictionary.put("Y", "B");
        treeFrogDictionary.put("Z", "A");
        treeFrogDictionary.put(" ", " ");

        String[] splitWord = word.split("");   // 한단어씩 공백 o

        for (String x : splitWord) {
            if (!isStringUpperCase(x)) {  // 소문자일시 대문자로 변환
                x = x.toUpperCase();
                if (treeFrogDictionary.containsKey(x)) {
                    answer += (treeFrogDictionary.get(x).toLowerCase());  // 다시 원래 소문자로 변환
                }
            } else {     // 대문자 그대로
                if (treeFrogDictionary.containsKey(x)) {
                    answer += (treeFrogDictionary.get(x));  // 그대로 반환
                }
            }
        }
        return answer;
    }

    private static boolean isStringUpperCase(String str) {
        return str.equals(str.toUpperCase());
    }
}
