package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> currencyList = List.of(50000, 10000, 5000, 1000,
                500, 100, 50, 10, 1);

        for (int i=0; i<currencyList.size(); i++) {
            int currency = currencyList.get(i);
            int numOfCurrency = money / currency;
            answer.add(numOfCurrency);
            money %= currency;
        }
        return answer;
    }
}

/*
<<요구사항>>
1. 1이상 1,000,000이하의 금액이 입력으로 들어온다
2. 5만원 ~ 1원짜리 화폐를 사용해 입력으로 들어오는 금액을 맞춘다
3. 이 때 화폐의 총 갯수를 최소한으로 한다
4. 5만원 ~ 1원짜리 화폐 각각의 개수가 담긴 리스트를 리턴한다
 */

/*
<<기능 목록>>
- [V] 50,000 ~ 1 까지가 담긴 화폐리스트를 만든다
- [V] 화폐리스트를 순회하며 해당 화폐로 금액을 나눈 몫을 구한다
- [V] 구한 몫을 answer리스트에 추가한다
- [V] 해당 화폐로 금액을 나눈 나머지를 금액에 할당한다
 */