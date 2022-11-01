package onboarding;

import java.util.HashMap;

public class Problem4 {

    public static String solution(String word) {
        String answer = "";

        HashMap<Character, Character> map = new HashMap<>();

        for (int i = 0; i <= 25; i++) {
            map.put((char) ('a' + i), (char) ('z' - i));
        }
        for (int i = 0; i <= 25; i++) {
            map.put((char) ('A' + i), (char) ('Z' - i));
        }
        char[] arr = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            if (map.containsKey(arr[i]))
                answer += map.get(arr[i]) +"";
            else
                answer += arr[i] + "";

        }

        return answer;
    }
}
