package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    /**
     * 지갑에 담기게 되는 결과 반환
     */
    private static int[] wallet(int money){
        int[] bill = {50000,10000,5000,1000,500,100,50,10,1};
        int[] answer = {0,0,0,0,0,0,0,0,0};
        for(int i=0;i<bill.length;i++){
            answer[i] = money/bill[i];
            money=money%bill[i];
        }
        return answer;
    }
}
