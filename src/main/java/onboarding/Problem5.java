package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = new ArrayList<>();

        // 오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전
        int[] d = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for(int i=0;i<d.length;i++){
            if(money/d[i]>0){
                answer.add(money/d[i]);
                money%=d[i];
            } else{
                answer.add(0);
            }
        }
        return answer;
    }
}
