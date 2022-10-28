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


        return answer;
    }
}
