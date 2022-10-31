package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> changeList = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        int leftMoney = money;

        for (Integer change : changeList) {
            answer.add(divideByChange(leftMoney, change));
            leftMoney = getRemainder(leftMoney, change);
        }
        return answer;
    }

    private static int divideByChange(int money, int change) {
        return (money / change);
    }

    private static int getRemainder(int money, int change){
        return (money % change);
    }
}
