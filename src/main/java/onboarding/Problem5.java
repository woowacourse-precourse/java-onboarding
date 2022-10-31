package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    enum Cash {
        length(9),
        division(5),
        def(0),
        fiveUnit(1);
        private final int value;
        Cash(int type) {
            this.value = type;
        }
    }
    enum Index {
        front(1);

        private  final int info;
        Index(int info) {
            this.info = info;
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
        List<Integer> digitNumber_list = new ArrayList<>();

        while (money > 0) {
            digitNumber_list.add(money % 10);
            money /= 10;
        }
        return digitNumber_list;
    }
    public static Integer [] divisionMoney(List<Integer> digitNumber_list) {
        Integer[] money_list = new Integer[Cash.length.value];
        int j = 0;
        int i;
        money_list[j] = digitNumber_list.get(j);

        for (i = 1; i < Cash.length.value; i++) {
            //홀수 일 때
            if (i % 2 == 1)
                money_list[i] = digitNumber_list.get(i - j);
            //짝수일 때
            if (i % 2 == 0) {
                if (money_list[i - Index.front.info] < Cash.division.value)
                    money_list[i] = Cash.def.value;
                if (money_list[i - 1] >= Cash.division.value) {
                    money_list[i] = Cash.fiveUnit.value;
                    money_list[i - 1] -= Cash.division.value;
                }
                j++;
            }
        }
        //9의 자리가 있을 경우
        if (i == Cash.length.value)
        {
            if (digitNumber_list.size() == 6)
                money_list[i - Index.front.info] += (digitNumber_list.get(5) * 10) / Cash.division.value;
            if (digitNumber_list.size() == 7)
                money_list[i - Index.front.info] += (digitNumber_list.get(6) * 100) / Cash.division.value;
        }
        return money_list;
    }

    /*
    예외 처리
     */
    public static void checkException(int money)
    {
        if (money < 1 || money > 1_000_000)
            throw new IllegalArgumentException("ERROR");
    }
}
