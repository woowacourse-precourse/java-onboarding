package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int moneyTmp = money;
        int []moneyCan = {50000, 10000, 5000, 1000, 500, 100, 50, 10,1};
        /**
         * 그리디 방법을 이용하여
         * 5만원 부터 1원까지 순차적으로
         * 큰돈이 필요로 하면 큰돈을 사용하는 방식으로 구현함
         */
        for(int i=0; i<9; i++){
            int cnt =0;
            cnt = moneyTmp / moneyCan[i];
            answer.add(cnt);
            moneyTmp = moneyTmp % moneyCan[i];
        }
        return answer;
    }
}
