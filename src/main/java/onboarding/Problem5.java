package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class NumberOfCurrency {
    private List<Integer> currencyList;

    public NumberOfCurrency() {
        this.currencyList = new ArrayList<>();
    }

    public void add(int number) {
        this.currencyList.add(number);
    }
    
    public List<Integer> get() {
        return this.currencyList;
    }
}
public class Problem5 {
    public static List<Integer> solution(int money) {
        /* 화폐 배열 생성 */
        List<Integer> currencyUnit = new ArrayList<>(Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1));
        /* 정답 배열 생성 */
        NumberOfCurrency numberOfCurrency = new NumberOfCurrency();
        /* 화폐 배열 Loop */
        for (int c : currencyUnit) {
            /* // 큰 화폐 단위 순으로 money를 나눈다. */
            numberOfCurrency.add(money / c);  // 몫 : 해당 화폐 개수
            money = money % c;  // 나머지 : 잔액
        }
        return numberOfCurrency.get();
    }
}