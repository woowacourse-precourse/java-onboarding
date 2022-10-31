package onboarding;

import java.util.Collections;
import java.util.List;

/*
========================================Problem5 기능 목록========================================
- 주어진 금액으로 나눌 수 있는지 확인하는 기능
- 주어진 금액으로 나누는 기능
- 주어진 금액으로 나눈 값을 리스트에 저장하는 기능
 */

public class Problem5 {
    int[] units = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static boolean checkDivisibleByUnit(int money, int unit){
        return (money / unit) > 0 ? true : false;
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }
}
