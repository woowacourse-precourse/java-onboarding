package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        // 5만 , 1만 , 5천 ,1천, 500원 , 100원 , 50원 , 10원
        Integer moneyList[] = new Integer[]{50000,10000,5000,1000,500,100,50,10,1};
        for(int i = 0;i<moneyList.length;i++) answer.add(0); // 리스트 인덱스로 접근하기위한 초기화
        /** 큰  금액으로 바꿀 수 있다면 계속 바꾼다 */
        for(int i = 0 ;i<moneyList.length;i++) {
            while (money >= moneyList[i]) {
                money -= moneyList[i];
                answer.set(i, answer.get(i) + 1);
            }
        }
        return answer;
    }
}
