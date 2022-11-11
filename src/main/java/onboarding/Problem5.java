package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        try{check(money);}
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return answer;
        }
        answer = find(money);
        return answer;
    }

    /**
     * 단위별로 각각 몇개로 나뉘는지 반환 */
    private static List<Integer> find(int money) {
        List<Integer> countOfMoney = new ArrayList<>(9);
        int[] unit = {50000,10000,5000,1000,500,100,50,10,1};
        for(int i=0;i<9;i++){
            countOfMoney.add(i, money/unit[i]);
            money = money%unit[i];
        }
        return countOfMoney;
    }

    private static void check(int money) {
        if(money < 1 || money > 1000000)
            throw new IllegalArgumentException("입력값이 범위 밖입니다.");
    }
}
