package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        // 오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전
        int[] moneyList = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        while(money != 0){
            for(int m:moneyList){
                answer.add(money / m);
                money %= m;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution(50237));
        System.out.println(solution(15000));
        System.out.println(solution(23570)); // [0, 2, 0, 3, 1, 0, 1, 2, 0]
    }
}
