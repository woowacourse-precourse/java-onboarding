package onboarding;

import java.util.HashMap;

public class Problem3 {
    private static HashMap<Character, Integer> map = new HashMap<>();
    public static int solution(int number) {
        map.put('3', 3);
        map.put('6', 3);
        map.put('9', 3);
        int clapCounts = 0;
        for (int i=1; i<=number; i++) {
            String convertedNum = String.valueOf(i);
            for (int j=0; j<convertedNum.length(); j++) {
                char targetNum = convertedNum.charAt(j);
                if (map.containsKey(targetNum)) {
                    clapCounts += 1;
                }
            }
        }
        return clapCounts;
    }
}
