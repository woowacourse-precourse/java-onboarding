package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 */

public class Problem5 {
    /*
     * 기능 정리 (★구현 정리로 바꿀 것)
     * 1. 화폐 금액 매핑 시키기
     * 2. 가장 큰 금액의 화폐부터 받아내어, 가장 적은 양으로 화폐를 받고 받은 화폐를 list에 저장.
     * */

    //1. 기능1
    static int moneyTable[] = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    //2. 기능2
    static List<Integer> getLeastMoney(int money) {

        int remainedMoney = money;

        List<Integer> leastMoney = new ArrayList<Integer>(Collections.nCopies(moneyTable.length, 0));

        for (int i = 0; remainedMoney > 0; ) {
            if (remainedMoney >= moneyTable[i]) {
                leastMoney.set(i, leastMoney.get(i) + 1);
                remainedMoney -= moneyTable[i];
            } else {
                i++;
            }
        }

        return leastMoney;
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = getLeastMoney(money);
        return answer;
    }
}
