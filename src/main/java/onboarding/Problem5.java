package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private final static int M_MAX = 1000000;
    private final static int M_MIN = 0;

    public static void moneycheck(int money){
        if(money >= M_MAX || money <= M_MIN){
            throw new RuntimeException("잘못된 값을 입력하셨습니다.");
        }
    }

    public static List<Integer> exchange(int money){
        int[] moneyunit = {50000, 10000, 5000, 1000, 500, 100, 50, 10 ,1};
        List<Integer> count = new ArrayList<>();

        for(int point: moneyunit) {
            count.add(money / point);
            money %= point;
        }
        return count;
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        moneycheck(money);
        answer = exchange(money);
        return answer;
    }
}