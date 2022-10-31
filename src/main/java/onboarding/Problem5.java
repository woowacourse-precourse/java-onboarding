package onboarding;

import java.util.*;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new LinkedList<>();
        int [] moneyUnit = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        answer = method(money, moneyUnit, 0, answer);
        return answer;
    }

    private static List<Integer> method(int money, int[] moneyUnit, int index, List<Integer> result){
        // @TODO :: 재귀로 돌아 answer return
        if(index == moneyUnit.length)
            return result;
        else{
            int quotient = money / moneyUnit[index];
            int remainMoney = money - quotient * moneyUnit[index];

            result.add(index, quotient);

            return method(remainMoney, moneyUnit, index+1, result);
        }
    }
}
