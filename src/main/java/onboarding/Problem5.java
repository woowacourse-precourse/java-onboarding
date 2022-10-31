package onboarding;

import java.util.LinkedList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        //오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전
        List<Integer> answer = new LinkedList<>();
        int[] arr = {50000,10000,5000,1000,500,100,50,10,1};

        for(int i : arr){
            int temp = money/i; // 숫자를 나눈후 저장
            money = money%i;    // 나눈 나머지를 저장 나눠진게 없으면 다시 원래대로 저장
            answer.add(temp);
        }

        return answer;
    }
}
