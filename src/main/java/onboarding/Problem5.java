package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

//문제 5번 기능 요구 사항
//1. 돈이 주어지면 각 화폐 개수 반환하는 기능

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        answer=new ArrayList<Integer>();

        int[] moneyList= {50000,10000,5000,1000,500,100,50,10,1};

        for(int i=0;i<moneyList.length;i++) {
            int moneyCount=0;
            moneyCount=money/moneyList[i];
            answer.add(moneyCount);
            money%=moneyList[i];
        }

        return answer;
    }
}
