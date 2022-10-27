package onboarding;

import utils.Problem4Util;

public class Problem4 {
    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            answer.append(Problem4Util.transform(ch));
        }
        return answer.toString();
    }
}
