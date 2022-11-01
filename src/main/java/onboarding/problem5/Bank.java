package onboarding.problem5;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Bank {

    private LinkedHashMap<Integer, Integer> bank = new LinkedHashMap<>();

    /*
     * 은행(LinkedHashMap)에 각 지폐와 동전별 초기 데이터 삽입 함수
     */
    public void init() {
        Integer[] moneys = new Integer[]{ 50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for(Integer money : moneys) {
            this.bank.put(money, 0);
        }
    }

    /*
     *  각 지폐와 동전별 money 변환 함수
     */
    public void exchangeMoney(Integer money) {

        for(Integer key: this.bank.keySet()) {

            Integer count = (Integer)(money / key);
            this.bank.put(key, count);
            money -= (key * count);
        }
    }

    /*
    * 각 지폐와 동전별 개수 반환 함수
    */
    public List<Integer> getExchangeResult() {
        return new ArrayList<>(this.bank.values());
    }
}
