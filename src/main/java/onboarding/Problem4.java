package onboarding;

import onboarding.problem04.entity.ReverseString;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        answer = ReverseString.from(word).processing();
        return answer;
    }
}
