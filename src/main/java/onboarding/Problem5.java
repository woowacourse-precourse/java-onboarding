package onboarding;

import java.util.*;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new LinkedList<>();
        int [] moneyUnit = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        answer = divideRecursively(money, moneyUnit, 0, answer);
        return answer;
    }

    /**
     *
     * @param money 현재 돈
     * @param moneyUnit 화폐 단위가 들어있는 배열 ex) 5만원, 1만원 -> [50000, 10000]
     * @param index 현재 돈을 나눠야 할 화폐단위가 있는 곳(moneyUnit)을 가르키는 index
     * @param result 결과
     * @return
     */
    private static List<Integer> divideRecursively(int money, int[] moneyUnit, int index, List<Integer> result){
        if(index == moneyUnit.length)
            return result;
        else{
            int quotient = money / moneyUnit[index];
            int remainMoney = money - quotient * moneyUnit[index];

            result.add(index, quotient);

            return divideRecursively(remainMoney, moneyUnit, index+1, result);
        }
    }
}
