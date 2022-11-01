package problem5;

import java.util.*;

public class Bank {

    public static final int CHANGE_FAIL_RESULT = 0;
    private final Map<Integer, Integer> bank;

    public Bank() {
        bank = new LinkedHashMap<>();
    }

    public List<Integer> changeAllMoney(int fromMoney) {
        for (MoneyUnit toMoney : MoneyUnit.values()) {
            int count = changeMoneyTo(fromMoney, toMoney.getPrice());
            fromMoney -= toMoney.getPrice() * count;
        }

        return new ArrayList<>(bank.values());
    }

    public int changeMoneyTo(int fromMoney, int toMoney) {
        int changeMoney = changeMoney(fromMoney, toMoney);
        saveChangeMoney(toMoney, changeMoney);

        return changeMoney;
    }

    private int changeMoney(int fromMoney, int toMoney) {
        if (canChangeMoney(fromMoney, toMoney)) {
            return fromMoney / toMoney;
        }
        return CHANGE_FAIL_RESULT;
    }

    private boolean canChangeMoney(int fromMoney, int toMoney) {
        return fromMoney >= toMoney;
    }

    private void saveChangeMoney(int toMoney, int changeMoney) {
        bank.put(toMoney, changeMoney);
    }
}
