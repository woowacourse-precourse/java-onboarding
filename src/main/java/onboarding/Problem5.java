package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> divideMoney(int money){
        List<Integer> withdraw = new ArrayList<>();
        int[] cash = {50000,10000,5000,1000,500,100,50,10,1};

        for (int i = 0; i < cash.length; i++) {
            int num = 0;
            if(money / cash[i] > 0){
                num += money / cash[i];
                money = money % cash[i];
            }
            withdraw.add(num);
        }
        return withdraw;
    }
    public static List<Integer> solution(int money) {
        List<Integer> answer = divideMoney(money);
        return answer;
    }
}
