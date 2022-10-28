package onboarding;

import java.util.*;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        Map<Integer, Character> map = new HashMap();
        List<Integer> greenFrogList = new ArrayList<>();

        for (int i = 90; i >= 65; i--) {
            greenFrogList.add(i);
        }
        for (int i = 0; i < greenFrogList.size(); i++) {
            int value = greenFrogList.get(i);
            map.put(i + 65, (char) +value);
        }

        for (int i = 1; i <= word.length(); i++) {

            int charNumber = word.charAt(i - 1);

            if (charNumber <= 90 && charNumber >= 65) {
                answer += map.get(charNumber);

            } else if (charNumber >= 90 && charNumber<=122) {
                int i1 = map.get(charNumber - 32) + 32;
                answer += (char) i1;
            }else {
                answer += word.charAt(i-1);
            }
        }

        return answer;
    }
}
