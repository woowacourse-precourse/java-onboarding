package onboarding;

import java.util.*;

public class Problem5 {
    public static List<Integer> solution(int money) {
        return restrictions(money)
                ? Collections.emptyList()
                : atm(money);
    }

    private static boolean restrictions(int money) {
        return money < 1 || money > 1_000_000;
    }

    private static List<Integer> atm(int money) {
        int simsaimdang = money / 50_000;
        int sejong = (money - simsaimdang * 50_000) / 10_000;
        int ehwang = (money - simsaimdang * 50_000 - sejong * 10_000) / 5_000;
        int ee = (money - simsaimdang * 50_000 - sejong * 10_000 - ehwang * 5_000) / 1_000;
        int hak = (money - simsaimdang * 50_000 - sejong * 10_000 - ehwang * 5_000 - ee * 1_000) / 500;
        int sunsin = (money - simsaimdang * 50_000 - sejong * 10_000 - ehwang * 5_000 - ee * 1_000 - hak * 500) / 100;
        int dabo = (money - simsaimdang * 50_000 - sejong * 10_000 - ehwang * 5_000 - ee * 1_000 - hak * 500 - sunsin * 100) / 50;
        int byu = (money - simsaimdang * 50_000 - sejong * 10_000 - ehwang * 5_000 - ee * 1_000 - hak * 500 - sunsin * 100 - dabo * 50) / 10;
        int mugung = (money - simsaimdang * 50_000 - sejong * 10_000 - ehwang * 5_000 - ee * 1_000 - hak * 500 - sunsin * 100 - dabo * 50 - byu * 10);

        return new ArrayList<>(Arrays.asList(simsaimdang, sejong, ehwang, ee, hak, sunsin, dabo, byu, mugung));
    }
}
