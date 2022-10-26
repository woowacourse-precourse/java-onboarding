package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    private static int[] quotientAndRemainder(int num, int divide){
        int[] qar = new int[2];
        qar[0] = num/divide;
        qar[1] = num%divide;
        return qar;
    }
}
