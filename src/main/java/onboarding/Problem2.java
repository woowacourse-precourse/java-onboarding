package onboarding;

import java.util.ArrayList;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    private static ArrayList<Character> stringToArrayList(String s) {
        ArrayList<Character> list = new ArrayList<Character>();
        for(int i = 0; i < s.length(); i++) {
            char currentCharacter = s.charAt(i);
            list.add(currentCharacter);
        }
        return list;
    }
}

