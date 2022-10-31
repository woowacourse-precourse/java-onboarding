package onboarding.problem5;

import java.util.ArrayList;
import java.util.List;

public class MoneyChanger {
    //화폐 종류 리스트
    private int[] currencies = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    //result 배열
    private List<Integer> result = new ArrayList<>();
    //화폐 종류와 잔금을 입력받아 result배열을 업데이트하고 잔금을 반환
    private Integer changeCurrency(Integer currency, int money){
        result.add(money / currency);
        money %= currency;
        return money;
    }
    //환금 함수
    public List<Integer> getChanges(int money) {
        result = new ArrayList<>();
        for(var currency: currencies)money = changeCurrency(currency, money);
        return result;
    }
}
