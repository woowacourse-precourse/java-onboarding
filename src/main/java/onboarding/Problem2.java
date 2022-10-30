package onboarding;

import java.util.ArrayList;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        ArrayList<Character> result = deduplication(cryptogram);
        for (int i = 0; i < result.size(); i++) {
            answer += result.get(i);
        }
        return answer;
    }


    public static ArrayList<Character> deduplication(String cryptogram) {
        ArrayList<Character> word = new ArrayList<>();

        for (int i = 0 ; i < cryptogram.length(); i++) {
            word.add(cryptogram.charAt(i));
        }

        int prev = 0, count = 0;

        while(true) {
            for (int i = 0 ; i < word.size() - 1; i++) {
                if (word.get(i) == word.get(i+1)) {
                    word.remove(i+1);
                    word.remove(i);
                    count++;
                }
            }
            if (prev == count) {
                break;
            }
            prev = count;
        }
        return word;
    }
}
