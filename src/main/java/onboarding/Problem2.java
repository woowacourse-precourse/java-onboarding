package onboarding;

import java.util.ArrayList;

public class Problem2 {
    static int global_iter = 0;
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        boolean isRepeat = true;

        while(true) {
//            if(answer.equals("") || !isRepeat) break;
            if(global_iter + 1 >= answer.length()) break;
            answer = check_continuity(global_iter, answer);

            global_iter += 1;
        }

        return answer;
    }

    public static String check_continuity(int iter, String word) {
        String s = word;
        char c = word.charAt(iter);
        int endIndex = iter;

        for(int i = iter + 1; i < word.length(); i++) {
            if (c != word.charAt(i)) break;

            endIndex += 1;
        }

        if(endIndex != iter) {
            s = s.replaceFirst(s.substring(iter, endIndex + 1), "");
            global_iter -= 1;
        }

        return s;
    }
}