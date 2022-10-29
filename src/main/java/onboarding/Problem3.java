package onboarding;

import java.util.HashSet;
import java.util.Set;

public class Problem3 {

    private static Set<Character> clapRule = new HashSet<>();

    public static int solution(int number) {
        addClapRule();
        int answer = 0;
        return answer;
    }

    private static void addClapRule() {
        clapRule.add('3');
        clapRule.add('6');
        clapRule.add('9');
    }
}
