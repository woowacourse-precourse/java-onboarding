package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int unitMoney = 50000;
        boolean divideFlag = true;
        while (unitMoney >= 10) {
            System.out.println(money + " " + unitMoney);
            answer.add(money / unitMoney);
            money = (money % unitMoney);
            unitMoney = divideFlag ? unitMoney / 5 : unitMoney / 2;
            divideFlag = !divideFlag;
        }
        answer.add(money);
        return answer;
    }
}
