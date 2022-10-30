package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    /*
    그리디 알고리즘 (큰 수 부터 욕심내여 담음) -가능한 이유: 약수들의 집합이기 떄문
     */
    private static List<Integer> minCount(int money){
        List<Integer> moneyIndex= new ArrayList<>(Arrays.asList(50000,10000,5000,1000,500,100,50,10,1));
        List<Integer> moneyCount=new ArrayList<>();
        for(int i=0;i<8;i++){
            int cnt=money/moneyIndex.get(i).intValue();
            moneyCount.add(cnt);
            money%=moneyIndex.get(i).intValue();
        }
        moneyCount.add(money);
        return moneyCount;
    }
}
