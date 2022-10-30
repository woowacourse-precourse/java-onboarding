package onboarding;

import java.util.ArrayList;

public class Problem2 {
    static ArrayList<Character> cryptogramList = new ArrayList<>();

    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    public static void addCryptogramList(String cryptogram) {
        for (int i = 0; i < cryptogram.length(); i++) {
            cryptogramList.add(cryptogram.charAt(i));
        }
    }
}