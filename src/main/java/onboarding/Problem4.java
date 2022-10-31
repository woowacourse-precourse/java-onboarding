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
        return answer.toString();
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
}
