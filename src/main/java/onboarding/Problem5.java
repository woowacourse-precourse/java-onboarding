package onboarding;

import java.util.*;

public class Problem5 {
    private static final List<Integer> moneys = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        countNeedMoneys(money, answer);
        return answer;
    }

    // moneys 리스트를 완전탐색하며 필요한 지폐의 갯수를 구하는 메서드
    private static void countNeedMoneys(int money, List<Integer> answer) {
        for (Integer m : moneys) {
            int tmp = 0;
            if (money >= m) {
                tmp = money / m;
                money %= m;
            }
            answer.add(tmp);
        }
    }
}
