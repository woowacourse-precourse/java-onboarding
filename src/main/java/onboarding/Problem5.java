package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    // 오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전
    public static List<Integer> solution(int money) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        answer.add(money/50000);
        answer.add(money%50000/10000);
        answer.add(money%10000/5000);
        answer.add(money%5000/1000);
        answer.add(money%1000/500);
        answer.add(money%500/100);
        answer.add(money%100/50);
        answer.add(money%50/10);
        answer.add(money%10);
        return answer;
    }
    //지폐로 전환
    public static void main(String[] args){
        System.out.println(solution(50237));
        System.out.println(solution(15000));
    }
}
