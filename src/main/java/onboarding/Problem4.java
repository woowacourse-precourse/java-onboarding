package onboarding;

import java.util.HashMap;
import java.util.Map;
public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        String alp = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Map<String, String> alpMap = new HashMap<>();
        addUppercaseToAlpMap(alp, alpMap);
        addLowercaseToAlpMap(alp, alpMap);
        return reverseValue(word, answer, alpMap);
    }
    private static void addUppercaseToAlpMap(String alp, Map<String, String> alpMap) {
        for(int i = 0; i < alp.length(); i++) {
            alpMap.put(String.valueOf(alp.charAt(i)),
                    String.valueOf(alp.charAt(alp.length()-1-i)));
        }
    }
    private static void addLowercaseToAlpMap(String alp, Map<String, String> alpMap) {
        for(int i = 0; i < alp.length(); i++) {
            alpMap.put(String.valueOf(alp.charAt(i)).toLowerCase(),
                    String.valueOf(alp.charAt(alp.length()-1-i)).toLowerCase());
        }
    }
    private static String reverseValue(String str, StringBuilder answer, Map<String, String> alpMap) {
        for(int i = 0; i < str.length(); i++) {
            String word = String.valueOf(str.charAt(i));
            if(word.equals(" ")){
                answer.append(" ");
            }else answer.append(alpMap.getOrDefault(word, word));
        }
        return answer.toString();
    }
}
