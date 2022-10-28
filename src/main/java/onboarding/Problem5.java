package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    static final int max = 9;
    static final int division = 5;
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        checkException(money);
        
        answer = Arrays.asList(divisionMoney(placeNumber(money)));
        Collections.reverse(answer);

        return answer;
    }

    //자리수 구분해 리스트에 넣음음
   public static List<Integer> placeNumber(int money) {
        List<Integer> digitNumber_list = new ArrayList<>();

        while (money > 0) {
            digitNumber_list.add(money % 10);
            money /= 10;
        }
        return digitNumber_list;
    }

    public static Integer [] divisionMoney(List<Integer> digitNumber_list) {
        Integer[] money_list = new Integer[max];
        int j = 0;

        money_list[0] = digitNumber_list.get(0);
        for (int i = 1; i < max; i++) {
            //홀수 일 때
            if (i % 2 == 1)
                money_list[i] = digitNumber_list.get(i - j);
            //짝수일 때
            if (i % 2 == 0) {
                if (money_list[i - 1] >= division) {
                    money_list[i] = 1;
                    money_list[i - 1] = money_list[i - 1] - division;
                } else if (money_list[i - 1] < division)
                    money_list[i] = 0;
                j++;
            }
            //9의 자리가 있을 경우
            if (i == max - 1)
            {
                if (digitNumber_list.size() == 6)
                    money_list[i] += (digitNumber_list.get(5) * 10) / division;
                if (digitNumber_list.size() == 7)
                    money_list[i] += (digitNumber_list.get(6) * 100) / division;
            }
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
