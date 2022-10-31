package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    enum Cash {
        length(9),
        min(1),
        max(1_000_000),
        division(5),
        zero(0),
        hundredTousand(5),
        million(6),
        round(1);
        private final int value;
        Cash(int type) {
            this.value = type;
        }
    }
    public static List<Integer> solution(int money) {
        List<Integer> answer;

        checkException(money);

        answer = Arrays.asList(divisionMoney(placeNumber(money)));
        Collections.reverse(answer);

        return answer;
    }

    //자리수 구분해 리스트에 넣음
    public static List<Integer> placeNumber(int money) {
        List<Integer> digit_list = new ArrayList<>();

        while (money > 0) {
            digit_list.add((money % 10));
            money /= 10;
        }

        return digit_list;
    }
    public static Integer [] divisionMoney(List<Integer> digit_list) {
        Integer[] won = new Integer[Cash.length.value];
        int digitCount = 0;
        int i;

        won[digitCount] = digit_list.get(digitCount);
        for (i = 1; i < Cash.length.value; i++) {
            if (i % 2 == 0) {
                checkFive(i - 1, won);
                digitCount++;
                continue;
            }
            won[i] = digit_list.get(i - digitCount);
        }
        if (i == Cash.length.value)
            checkFiveTousand(won, digit_list);

        return won;
    }

    //50,500,5000원 확인
    public static void checkFive(int status, Integer[] money) {
        if (money[status] < Cash.division.value)
            money[status + 1] = Cash.zero.value;

        if (money[status] >= Cash.division.value) {
            money[status] -= Cash.division.value;
            money[status + 1] = Cash.round.value;
        }
    }
    public static void checkFiveTousand(Integer[] won, List<Integer> digit) {
        if (digit.size() == (Cash.hundredTousand.value + 1))
            won[Cash.length.value - 1] += digit.get(Cash.hundredTousand.value) * 10 / Cash.division.value;

        if (digit.size() == (Cash.million.value + 1))
            won[Cash.length.value - 1] += digit.get(Cash.million.value) * 100 / Cash.division.value;
    }

    /*
    예외 처리
     */
    public static void checkException(int money) {
        if (money < Cash.min.value || money > Cash.max.value)
            throw new IllegalArgumentException("ERROR");
    }
}
