package onboarding;

import java.util.*;

public class Problem5 {
    public static List<Integer> solution(int money) {
        makeBillAndCoin();
        ArrayList<Integer> resultList = divideByBillAndCoin(money);
        return resultList;
    }

    private static ArrayList<Integer> divideByBillAndCoin(int money) {
        ArrayList<Integer> billAndCoinList = new ArrayList<> ();
        int quotient = 0;
        int remainder = money;
        for ( Integer key : billAndCoin.keySet() ){
            System.out.println("key is");
            System.out.println(key);
            int divisor = billAndCoin.get(key);
            quotient = (int)(remainder / divisor);
            remainder = remainder % divisor;
            System.out.println("quotient is");
            System.out.println(quotient);
            System.out.println("remainder is");
            System.out.println(remainder);
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
        System.out.println("billAndCoinList is");
        System.out.println(billAndCoinList);
    }

    public static void makeBillAndCoin() {
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
    }
}
