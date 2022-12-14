//1. 필요한 화폐의 개수를 담을 moneyCount List 만들어주고, 화폐의 금액을 큰 금액 순서로 moneyList에 담기
//2. moneyList 순회하면서 필요한 화폐의 개수만큼 moneyCount 리스트에 담아주기
package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        List<Integer> moneyCount = new ArrayList<>();
        int[] moneyList = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int i = 0 ; i < 9 ; i++) {
            moneyCount.add(money/moneyList[i]);
            money = money%moneyList[i];
        }
        return moneyCount;
    }
}
