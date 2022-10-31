package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static int[] won = new int[9];
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        initWon();
        return answer;
    }

    public static void initWon() {
        won[0] = 50000;
        won[1] = 10000;
        won[2] = 5000;
        won[3] = 1000;
        won[4] = 500;
        won[5] = 100;
        won[6] = 50;
        won[7] = 10;
        won[8] = 1;
    }
}
