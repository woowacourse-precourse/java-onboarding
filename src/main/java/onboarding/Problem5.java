package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    static int [] withdraw_list= {50000,10000,5000,1000,500,100,50,10,1};
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        try {
            checkNumberRange(money);
            for (int i = 0; i < withdraw_list.length; i++) {
                int moneyWithdraw = getMoneyWithdraw(money, withdraw_list[i]);
                answer.add(moneyWithdraw);
                money -= withdraw_list[i] * moneyWithdraw;
            }
            return answer;
        } catch (Exception e) {
            return answer;
        }
    }

    public static int getMoneyWithdraw(int money,int withdraw_i){
        return money/withdraw_i;
    }

    public static void checkNumberRange(int money_range) throws Exception {
        if (money_range<1||money_range>1000000) throw new Exception("숫자 범위 초과");
    }
}
