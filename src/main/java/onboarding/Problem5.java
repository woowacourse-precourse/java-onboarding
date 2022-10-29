package onboarding;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem5 {
    static final int FIVE_MILLION_WON = 50000;
    static final int ONE_MILLION_WON = 10000;
    static final int FIVE_THOUSAND_WON = 5000;
    static final int ONE_THOUSAND_WON = 1000;
    static final int FIVE_HUNDRED_WON = 500;
    static final int ONE_HUNDRED_WON = 100;
    static final int FIFTY_WON = 50;
    static final int TEN_WON = 10;
    static final int ONE_WON = 1;
    static Queue<Integer> billUnitQueue = new LinkedList<>();

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    public static List<Integer> putInArray(List<Integer> countedList, int money) {
        int balance = money;
        while (!billUnitQueue.isEmpty()) {
            countedList.add(countBills(balance, billUnitQueue.peek()));
            balance = calculateBalance(balance, billUnitQueue.poll());
        }
        return countedList;
    }

    public static int countBills(int money, int bill) {
        return money / bill;
    }

    public static int calculateBalance(int money, int bill) {
        return money % bill;
    }

    public static void addBillUnitQueue() {
        List<Integer> billList
                = List.of(FIVE_MILLION_WON, ONE_MILLION_WON,
                FIVE_THOUSAND_WON, ONE_THOUSAND_WON, FIVE_HUNDRED_WON,
                ONE_HUNDRED_WON, FIFTY_WON, TEN_WON, ONE_WON);
        billUnitQueue.addAll(billList);
    }
}