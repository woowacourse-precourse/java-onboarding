package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int divided_result;
        int money_result = money;
        int divisor = 100000;
        for (int i = 0; i < 9; i++) {
            //금액: 1
            if (i == 8)
                divisor = 1;
                //금액: 50000,5000,500,50
            else if (i % 2 == 0)
                divisor = divisor / 2;
                //금액: 10000,1000,100,10
            else
                divisor = divisor / 5;

            //해당 금액으로 변환될 수 있다면 answer에 갯수 추가, or 0추가
            if (money_result >= divisor) {
                divided_result = money_result / divisor;
                money_result = money_result % divisor;
                answer.add(divided_result);
            } else {
                answer.add(0);
            }

        }
        // 50000/10000/5000/1000/500/100/50/10/1
        return answer;
    }


}
