package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer=to_list(wallet(money));
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

    /**
     * int[] -> List<Integer> 변환하는 함수
     */
    private static List<Integer> to_list(int[] arr){
        List<Integer> list = new ArrayList<>(arr.length);
        for (int i: arr)
            list.add(Integer.valueOf(i));
        return list;
    }
}
