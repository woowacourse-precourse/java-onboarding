package onboarding;

import java.util.*;

public class Problem2 {
    public static ArrayList<String> divideWord(String word) {
        ArrayList<String> crypto = new ArrayList<>();

        for (int a = 0; a < word.length(); a++) {
            crypto.add(String.valueOf(word.charAt(a)));
        }

        return crypto;
    }

    public static String solution(String cryptogram) {
        String answer = "answer";
        // 1. 문자를 따로 나눔
        ArrayList<String> word = divideWord(cryptogram);
        // 2. 연속적이고 중복된 문자의 인덱스를 구하고 제거
        // 3. 제거 후 남은 문자 재조합

        return answer;
    }
}
