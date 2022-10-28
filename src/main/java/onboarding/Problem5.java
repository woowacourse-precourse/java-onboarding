package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    static int max = 9;
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        answer = Arrays.asList(divisionMoney(digit(money)));
        Collections.reverse(answer);

        return answer;
    }

    //자리수 구분해 리스트에 넣음음
   public static List<Integer> digit(int number)
    {
        List<Integer> digitNumber = new ArrayList<>();

        while (number > 0)
        {
            digitNumber.add(number % 10);
            number /= 10;
        }
        return digitNumber;
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
                if (money_list[i - 1] >= 5) {
                    money_list[i] = 1;
                    money_list[i - 1] = money_list[i - 1] - 5;
                } else if (money_list[i - 1] < 5)
                    money_list[i] = 0;
                j++;
            }
            //9의 자리가 있을 경우
            if (i == max - 1)
            {
                if (digitNumber_list.size() == 6)
                {
                    money_list[i] += (digitNumber_list.get(5) * 10) / 5;
                }
                if (digitNumber_list.size() == 7)
                {
                    money_list[i] += (digitNumber_list.get(6) * 100) / 5;
                }
            }
        }
        return money_list;
    }
}
