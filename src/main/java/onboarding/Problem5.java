package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    /**
     *화폐 갯수 세는 함수
     */
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    /*
     *화폐 갯수 세는 함수
     */
    static List<Integer> cal(int money){
        List<Integer> answer = new ArrayList<>();
        int[] list = {50000,10000,5000,1000,500,100,50,10,1};

        answer.add((money/list[0]));

        for(int i=0;i<list.length-1;i++){
            int count = (money%list[i])/list[i+1];
            answer.add(count);
        }
        return answer;
    }
}
