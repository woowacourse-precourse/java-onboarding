package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        //지폐 종류 저장
        List<Integer> sort = new ArrayList<>(List.of(50000,10000,5000,1000,500,100,50,10,1));
        answer = new ArrayList<>(List.of(0,0,0,0,0,0,0,0,0));

        //지폐 종류만큼 반복하기
        for(int i=0; i< sort.size(); i++){
            int cnt = money/sort.get(i);
            //해당 종류가 1장이상일 경우, 갯수 저장 및 머니 감소
            if (cnt >= 1) {
                answer.set(i,cnt);
                money -= sort.get(i)*cnt;
            }
        }
        return answer;
    }
}
