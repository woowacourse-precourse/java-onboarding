package onboarding.problem5;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private static final int[] BILLS = new int[] {50_000, 10_000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> getResult(int restMoney) {
        int[] changes = new int[9];
        int idx = 0;
        while (restMoney != 0) {
            idx = selectBill(idx, restMoney);
            restMoney = calculateMoney(idx, restMoney, changes);
        }
        return setChangeArrayToChangeList(changes);
    }

    private static List<Integer> setChangeArrayToChangeList(int[] array) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int number : array) {
            arrayList.add(number);
        }
        return arrayList;
    }

    private static boolean isLessMoneyThanBill(int billIdx, int restMoney) {
        return restMoney < BILLS[billIdx];
    }

    private static int selectBill(int billIdx, int restMoney){
        while (isLessMoneyThanBill(billIdx, restMoney)) {
            billIdx++;
        }
        return billIdx;
    }

    private static void addBill(int billIdx, int[] changes) {
        changes[billIdx]++;
    }

    private static int calculateMoney(int billIdx, int restMoney, int[] changes) {
        addBill(billIdx, changes);
        return restMoney - BILLS[billIdx];
    }
}
