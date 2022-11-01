/*
1. 거스름돈 계산
 */
package onboarding;
import java.util.*;

public class Problem5 {
    public static List<Integer> solution(int money) {
        Bank bank = new Bank(Arrays.asList(1, 10, 50, 100, 500, 1000, 5000, 10000, 50000));
        return bank.withdraw(money);
    }
}

class Bank {
    HashSet<Integer> cashList;
    List<Integer> sortedCashList;
    public Bank(List<Integer> cashList) {
        this.cashList = new HashSet<>(cashList);
        this.sortedCashList = cashList;
        Collections.sort(this.sortedCashList, (a,b) -> b-a);
    }
    public boolean isCashExisted (int cash) {
        return cashList.contains(cash);
    }
    public void addCash (int cash) {
        cashList.add(cash);
        sortedCashList.add(cash);
        Collections.sort(this.sortedCashList);
    }
    public void deleteCash (int cash) {
        if (!isCashExisted(cash)) {
            System.out.printf("%d 화폐 종류는 존재하지 않습니다.\n", cash);
            return;
        }
        cashList.remove(cash);
        sortedCashList.remove(cash);
    }
    public List<Integer> withdraw (int money) {
        List<Integer> withdrawal = new ArrayList<>();
        for (int cash : sortedCashList) {
            withdrawal.add(money / cash);
            money %= cash;
        }
        return withdrawal;
    }
}