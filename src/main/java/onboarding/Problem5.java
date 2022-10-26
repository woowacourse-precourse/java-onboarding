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

        ///System.out.println(divisionMoney(digit(money)));
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

    public static Integer [] divisionMoney(List<Integer> digitNumber) {
        Integer[] moneyList = new Integer[max];
        int j = 0;

        moneyList[0] = digitNumber.get(0);
        for (int i = 1; i < max; i++)
        {
            //홀수 일 때
            if (i % 2 == 1 && i < max - 1)
                moneyList[i] = digitNumber.get(i - j);
            //짝수일 때
            else if (i % 2 == 0)
            {
                if (moneyList[i - 1] >= 5)
                {
                    moneyList[i] = 1;
                    moneyList[i - 1] = moneyList[i - 1] - 5;
                }
                else if (moneyList[i - 1] < 5)
                    moneyList[i] = 0;
                j++;
            }
        }

        return moneyList;
    }
}
