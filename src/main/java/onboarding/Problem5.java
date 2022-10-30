package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    static final int[] MEASURE = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            answer.add(getCountOfBill(MEASURE[i], money));
            money -= MEASURE[i] * answer.get(i);
        }
        return answer;
    }

    public static int getCountOfBill(int measure, int won) {
        return won / measure;
    }
}
