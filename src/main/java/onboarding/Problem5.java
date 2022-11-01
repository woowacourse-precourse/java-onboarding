package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static void main(String[] args) {
        System.out.println(solution(50237));
    }
    public static List<Integer> solution(int money) {
        List<Integer> answer = new java.util.ArrayList<>(Collections.emptyList());

        int []monetary = {50000,10000,5000,1000,500,100,50,10,1};
        int unitCnt = 0;

        for (int j : monetary) {
            unitCnt = money / j;
            answer.add(Math.max(unitCnt, 0));
                money = money % j;
            }
        return answer;
    }
}
