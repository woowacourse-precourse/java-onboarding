package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    // 동전 갯수 반환 함수 - 그리디
    static List<Integer> balance(int money){
        int[] coins = {50000,10000,5000,1000,500,100,50,10,1};
        List<Integer> result = new ArrayList<>();
        while(money > 0){
            for (int coin : coins){// 코인 개수만큼 나누기
                int div = money / coin;
                result.add(div);
                money -= div * coin;
            }
        }
        return result;
    }
    public static List<Integer> solution(int money) {
        List<Integer> answer;
        answer = balance(money);
        return answer;
    }
}
