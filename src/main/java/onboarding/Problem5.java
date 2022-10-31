package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
========================================Problem5 기능 목록========================================
- 주어진 금액으로 나눌 수 있는지 확인하는 기능
- 주어진 금액으로 나누는 기능
- 주어진 금액으로 나눈 값을 리스트에 저장하는 기능
 */

public class Problem5 {
    static int[] units = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static boolean checkDivisibleByUnit(int money, int unit){
        return (money / unit) > 0 ? true : false;
    }

    public static int diviseMoneyByUnit(int money, int unit) {
        return (money / unit);
    }

    public static List<Integer> countUnit(int money){
        int[] array;
        array = new int[9];

        int unitLen = units.length;
        int tempMoney = money;

        for(int i = 0;i < unitLen;i++){
            if(checkDivisibleByUnit(tempMoney, units[i])){
                array[i] = diviseMoneyByUnit(tempMoney, units[i]);
                tempMoney -= (array[i] * units[i]);
            }
        }
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
        return list;
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }
}
