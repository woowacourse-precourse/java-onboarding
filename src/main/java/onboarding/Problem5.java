package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int unit[] = new int[]{50000,10000,5000,1000,500,100,50,10,1};  //화폐 단위
        List<Integer> answer = new ArrayList<>();

        for (int i=0; i<9; i++) {
            answer.add(money / unit[i]);
            money %= unit[i];   //화폐 단위의 나머지로 money 값을 수정
        }
        return answer;
    }
}
