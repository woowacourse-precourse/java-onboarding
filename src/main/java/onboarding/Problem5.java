package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    static int[] makeCharge(int money){
        int[] arr = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int[] result = new int[9];

        for (int i = 0; i<9; i++){
            result[i] = money/arr[i];
            money %= arr[i];
        }

        return result;
    }
}
