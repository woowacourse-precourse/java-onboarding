package onboarding.promble5;

import java.util.ArrayList;
import java.util.List;

public class PennyGame {

    public static List<Integer> start(int money) {
        List<Integer> result = new ArrayList<>();

        int share = money / Penny.FIFTY_THO.getMoney();
        result.add(share);

        if (share != 0) {
            money = money - share * Penny.FIFTY_THO.getMoney();
        }
        share = money / Penny.TENTH.getMoney();
        result.add(share);

        if (share != 0) {
            money = money - share * Penny.TENTH.getMoney();
        }
        share = money / Penny.FIVE_THO.getMoney();
        result.add(share);

        if (share != 0) {
            money = money - share * Penny.FIVE_THO.getMoney();
        }
        share = money / Penny.THOUSAND.getMoney();
        result.add(share);

        if (share != 0) {
            money = money - share * Penny.THOUSAND.getMoney();
        }
        share = money / Penny.FIVE_HUNDRED.getMoney();
        result.add(share);

        if (share != 0) {
            money = money - share * Penny.FIVE_HUNDRED.getMoney();
        }
        share = money / Penny.HUNDRED.getMoney();
        result.add(share);

        if (share != 0) {
            money = money - share * Penny.HUNDRED.getMoney();
        }
        share = money / Penny.FIFTY.getMoney();
        result.add(share);

        if (share != 0) {
            money = money - share * Penny.FIFTY.getMoney();
        }
        share = money / Penny.TEN.getMoney();
        result.add(share);

        if (share != 0) {
            System.out.println(money);
            money = money - (share * Penny.TEN.getMoney());
        }
        result.add(money);

        return result;
    }
}
