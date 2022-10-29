package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    public static final int FIRST_NUMBER_FIVE = 5;
    public static final int FIRST_NUMBER_ONE = 1;
    public static final int TENS = 10;
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        int calculateMoney = 50000;
        int check = 5;

        calculate(money, answer, calculateMoney, check);
        return answer;
    }

    private static void calculate(int money, List<Integer> answer, int calculateMoney, int check) {
        while (true) {
            int countMoney = money / calculateMoney;

            answer.add(countMoney);
            money -= countMoney * calculateMoney;

            if (isOnes(calculateMoney)) {
                break;
            }
            if (check == FIRST_NUMBER_FIVE) {
                calculateMoney /= 5;
                check = 1;
            } else if (check == FIRST_NUMBER_ONE) {
                if (calculateMoney == TENS) {
                    calculateMoney /= 10;
                } else if (calculateMoney != TENS) {
                    calculateMoney /= 2;
                    check = 5;
                }
            }
        }
    }

    private static boolean isOnes(int calculateMoney) {
        return calculateMoney == 1;
    }
}
