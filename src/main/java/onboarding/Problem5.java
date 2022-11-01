package onboarding;

import java.util.*;

public class Problem5 {
    public static List<Integer> solution(int money) {
        // 주어진 금액을 큰 액수의 권종부터 나눗셈한다.
        return divideByBillAndCoin(money);
    }

    /**
     * 주어진 금액을 큰 액수의 권종으로 나눗셈하여 몫과 나머지를 계산한다.
     * @param money 주어진 금액
     * @return 지폐와 동전의 권종별 수량 리스트
     */
    private static ArrayList<Integer> divideByBillAndCoin(int money) {
        ArrayList<Integer> billAndCoinList = new ArrayList<>();

        // 지폐와 동전의 종류를 큰 권종부터 순서대로 기록할 수 있는 LinkedHashMap을 만든다.
        Map<Integer, Integer> billAndCoin = makeBillAndCoin();

        // 나머지 초기값 설정
        int remainder = money;

        // 지폐와 동전의 큰 권종부터 몫과 나머지를 계산한다.
        for ( Integer key : billAndCoin.keySet() ){
            int divisor = billAndCoin.get(key);
            int quotient = remainder / divisor;
            remainder = remainder % divisor;

            // 몫이 1 이상인지 미만인지 확인하고 기록한다.
            checkQuotientAndRecord(quotient, billAndCoinList);
        }
        return billAndCoinList;
    }

    /**
     * 몫이 1 이상인지 미만인지 확인하고 기록한다.
     * @param quotient 몫
     * @param billAndCoinList 지폐와 동전의 개수를 기록한 리스트
     */
    private static void checkQuotientAndRecord(int quotient, ArrayList<Integer> billAndCoinList) {
        if (quotient >= 1) {
            billAndCoinList.add(quotient);
        } else if (quotient < 1) {
            billAndCoinList.add(quotient);
        }
    }

    /**
     * 지폐와 동전의 종류를 큰 권종부터 순서대로 기록할 수 있는 LinkedHashMap을 만든다.
     * @return 지폐와 동전의 종류가 기록되어있는 LinkedHashMap
     */
    public static Map<Integer, Integer> makeBillAndCoin() {
        Map<Integer, Integer> billAndCoin = new LinkedHashMap<>();

        billAndCoin.put(50000, 50000);
        billAndCoin.put(10000, 10000);
        billAndCoin.put(5000, 5000);
        billAndCoin.put(1000, 1000);
        billAndCoin.put(500, 500);
        billAndCoin.put(100, 100);
        billAndCoin.put(50, 50);
        billAndCoin.put(10, 10);
        billAndCoin.put(1, 1);
        return billAndCoin;
    }
}
