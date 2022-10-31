package onboarding;

import onboarding.problemfour.domain.Frog;

public class Problem4 {
    public static String solution(String word) {

        Frog frog=new Frog();

        String answer = frog.convert(word);
        return answer;
    }
}
