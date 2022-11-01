package onboarding;

import java.util.*;

public class Problem5 {
    public static List<Integer> solution(int money) {
        ArrayList<Integer> resultList = divideByBillAndCoin(money);
        return resultList;
    }

    private static ArrayList<Integer> divideByBillAndCoin(int money) {
        ArrayList<Integer> billAndCoinList = new ArrayList<> ();
        Map<Integer, Integer> billAndCoin = makeBillAndCoin();
        int quotient = 0;
        int remainder = money;
        for ( Integer key : billAndCoin.keySet() ){
            int divisor = billAndCoin.get(key);
            quotient = (int)(remainder / divisor);
            remainder = remainder % divisor;
            checkQuotient(quotient, billAndCoinList);
        }
        return billAndCoinList;
    }

    private static void checkQuotient(int quotient, ArrayList<Integer> billAndCoinList) {
        if (quotient >= 1) {
            billAndCoinList.add(quotient);
        } else if (quotient < 1) {
            billAndCoinList.add(quotient);
        }
    }

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
