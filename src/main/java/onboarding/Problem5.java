package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
a. 각 단위 선언
b. 큰 단위부터 money 계산
 */
public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> units = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        int nowMoney = money;
        for(int i : units){
            int count = nowMoney / i;
            nowMoney -= count * i;
            answer.add( count);
        }
        return answer;
    }
}
