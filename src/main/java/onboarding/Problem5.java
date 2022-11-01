package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = calc(money);

        return answer;
    }

    public static List<Integer> calc(int money) {
        List<Integer> result = new ArrayList<>();

        int[] unitArr = new int[9];

        unitArr[0] = 50000;
        unitArr[1] = 10000;
        unitArr[2] = 5000;
        unitArr[3] = 1000;
        unitArr[4] = 500;
        unitArr[5] = 100;
        unitArr[6] = 50;
        unitArr[7] = 10;
        unitArr[8] = 1;

        for (int index = 0; index < unitArr.length; index++) {
            result.add(money / unitArr[index]);
            money %= unitArr[index];
        }

        return result;
    }
}
