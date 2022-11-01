package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static int coin[] = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = new ArrayList();

        findNumberOfCoin(money , answer);
//        for (int i = 0; i < 9; i++){
//            System.out.println(answer.get(i));
//        }
        return answer;
    }

    private static void findNumberOfCoin(int money, List<Integer> answer) {
        int count = 0;
        int n = 0;

        while (n < 9) {
            answer.add(money / coin[n]);
            money = money % coin[n];
            n++;
        }
    }
}
