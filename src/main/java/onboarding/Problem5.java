package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    static int fiftyThousandWon, tenThousandWon, fiveThousandWon, thousandWon, fiveHundredWon, hundredWon, fiftyWon, tenWon, won = 0;
    /* 오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전 */
    public static List<Integer> solution(int money) {

        if(money >= 50000){
            fiftyThousandWon = money / 50000;
            money %= 50000;
        }
        if(money >= 10000) {
            tenThousandWon = money / 10000;
            money %= 10000;
        }
        if (money >= 5000) {
            fiveThousandWon = money / 5000;
            money %= 5000;
        }
        if (money >= 1000) {
            thousandWon = money / 1000;
            money %= 1000;
        }
        if(money >= 500) {
            fiveHundredWon = money / 500;
            money %= 500;
        }
        if(money >= 100) {
            hundredWon = money / 100;
            money %= 100;
        }
        if(money >= 50) {
            fiftyWon = money / 50;
            money %= 50;
        }
        if(money >= 10) {
            tenWon = money / 10;
            money %= 10;
        }

        won = money;

        List<Integer> answer = List.of(fiftyThousandWon,
                                        tenThousandWon,
                                        fiveThousandWon,
                                        thousandWon,
                                        fiveHundredWon,
                                        hundredWon,
                                        fiftyWon,
                                        tenWon,
                                        won);

        return answer;

    }
}
