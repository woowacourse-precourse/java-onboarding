package onboarding;

import java.util.List;

public class Problem3 {
    private static final List<Integer> CLAP_NUMBER = List.of(3,6,9);
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    private static boolean isContainClapNumber(int currentNumber) {
        return CLAP_NUMBER.contains(currentNumber % 10);
    }

}
