package onboarding;

import java.util.*;

/**
 * 기능 :
 *  1. money가 주어 질 때, 오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원동전, 일원 동전 각각 몇개로 변환되는지
 *    금액이 큰 순서대로 리스트/배열에 담아 return
 * 제한 사항 :
 *  1. money는 1 이상 1,000,000 이하인 자연수
 */
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
