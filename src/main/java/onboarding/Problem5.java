package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer=calcMoney(money);
        return answer;
    }
    //큰 금액부터 돈 나누는 함수 구현
    private static List<Integer> calcMoney(int money){
        int []arr= {50000,10000,5000,1000,500,100,50,10,1};
        List<Integer> result = new ArrayList<>(arr.length);
        for(int i=0; i<arr.length; i++){
            int moneyNum = money/arr[i];
            result.add(moneyNum);
            money-=(arr[i]*moneyNum);
        }
        return result;
    }
}
