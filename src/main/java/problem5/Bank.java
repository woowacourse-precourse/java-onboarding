package problem5;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final int[] UNIT
            = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    private int money;

    public Bank(int money) {
        this.money = money;
    }

    public List<Integer> withdraw() {
        List<Integer> wallet = new ArrayList<>();
        int now = money;

        for (int i = 0; i < 9; i++) {
            now -= exchangeCurrency(wallet, now, i);
        }
        return wallet;
    }

    private int exchangeCurrency(List<Integer> wallet, int now, int i) {
        int cnt = now / UNIT[i];
        if (isExchange(cnt)) {
            wallet.add(cnt);
            return cnt * UNIT[i];
        }

        wallet.add(0);
        return 0;
    }

    private boolean isExchange(int cnt) {
        return cnt != 0;
    }

}
