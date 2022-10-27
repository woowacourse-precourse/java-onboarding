package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    /**
     - 문제:
     5만원,만원,오천원,오백원,백원,오십원,십원,일원 동전 기준으로 몇개가 반환되는지를 큰 금액 순서대로 리스트에 담아 반환

     - 제한 사항:
     1 ~ 1,000,000 자연수
     **/
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        // 50000
        if(money >= 50000){
            Integer fiveTMil = money / 50000;
            money = money - (50000*fiveTMil);
            answer.add(fiveTMil);
        }
        else answer.add(0);

        if (money >= 10000) {
            // 10000
            Integer oneTMil = money / 10000;
            money = money - (10000*oneTMil);
            answer.add(oneTMil);
        }
        else answer.add(0);

        if (money >= 5000) {
            //5000
            Integer fiveMil = money / 5000;
            money = money - (5000*fiveMil);
            answer.add(fiveMil);
        }
        else answer.add(0);

        if (money >= 1000) {
            //1000
            Integer oneMil = money / 1000;
            money = money - (1000 * oneMil);
            answer.add(oneMil);
        }
        else answer.add(0);

        if (money >= 500) {
            // 500
            Integer fiveT = money / 500;
            money = money - (500 * fiveT);
            answer.add(fiveT);
        }
        else answer.add(0);

        if (money >= 100) {
            // 100
            Integer oneT = money / 100;
            money = money - (100 * oneT);
            answer.add(oneT);
        }
        else answer.add(0);

        if (money >= 50) {
            // 50
            Integer fiT = money / 50;
            money = money - (50 * fiT);
            answer.add(fiT);
        }
        else answer.add(0);

        if (money >= 10) {
            // 10
            Integer onT = money / 10;
            money = money - (10 * onT);
            answer.add(onT);
        }
        else answer.add(0);

        answer.add((Integer) money);

        return answer;
    }
}
