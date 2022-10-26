package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer=changeMoney(money);
        return answer;
    }

    public static List<Integer> changeMoney(int money){
        List<Integer> result = new ArrayList<Integer>();
        /**
         * 지폐와 동전 종류를 배열로 저장
         */
        int[] billsAndChanges = {50000,10000,5000,1000,500,100,50,10,1};
        for(int i = 0; i<billsAndChanges.length;i++) {
            result.add(money / billsAndChanges[i]);
            money = money % billsAndChanges[i];
        }

        return result;



    }
}
