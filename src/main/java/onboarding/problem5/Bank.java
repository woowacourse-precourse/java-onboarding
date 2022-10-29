package onboarding.problem5;

public class Bank {
    private static final int[] BILLS = new int[] {50_000, 10_000, 5000, 1000, 500, 100, 50, 10, 1};

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
