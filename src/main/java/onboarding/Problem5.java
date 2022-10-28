package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    /*기능 목록
    1. 화폐단위들을 정수 배열로 만든다.
    2. 주어진 금액을 1의 원소로 나눈다. 몫은 새로운 List에 담고, 나머지는 금액에 입력시킨다.
    3. 이를 반복시키면 각 단위로 나눈 몫은 List에 들어가고, 나머지는 다음 연산에 사용된다. 이를 리턴시킨다.
    */

    static final int[] MONEY_UNIT = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};


    public static List<Integer> solution(int money) {
        return countCurrencies(money);
    }

    private static List<Integer> countCurrencies(int money){
        List<Integer> currencies = new ArrayList<>();
        for (int currency : MONEY_UNIT) {
            currencies.add(money / currency);
            money = money % currency;
        }
        return currencies;
    }
}
