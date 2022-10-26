package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    static int max = 9;
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        //answer = divisionMoney(digit(money));
        System.out.println(divisionMoney(digit(money)));
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

        System.out.println("자리수 : " + digitNumber);
        return digitNumber;
    }

    public static int [] divisionMoney(List<Integer> digitNumber) {
        int[] moneyList = new int[max];
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
