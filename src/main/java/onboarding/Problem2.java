package onboarding;

import java.util.*;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        int no = 0;
        answer = cryptogram;
        while (true) {
            char[] chArr = answer.toCharArray();
            List<Character> li = new ArrayList<>();
            for (int i = 0; i < answer.length() - 1; i++) {
                if (chArr[i] == chArr[i + 1]) {
                    i++;
                    no++;
                } else {
                    li.add(chArr[i]);
                }
                if (i == answer.length() - 2 && chArr[i] != chArr[i + 1])
                    li.add(chArr[i + 1]);
            }
            StringBuilder sb = new StringBuilder();
            for (Character a : li) {
                sb.append(a);
            }
            answer = sb.toString();
            if (no == 0)
                break;
            no = 0;
        }
        return answer;
    }
}
