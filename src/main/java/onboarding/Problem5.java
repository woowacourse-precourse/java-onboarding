package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {


        List<Integer> answer = new ArrayList();
        List<Integer> money_lis = new ArrayList();
        money_lis.add(50000);
        money_lis.add(10000);
        money_lis.add(5000);
        money_lis.add(1000);
        money_lis.add(500);
        money_lis.add(100);
        money_lis.add(50);
        money_lis.add(10);
        money_lis.add(1);

        for(int i = 0; i < money_lis.size(); i++ ){
            int cash = money_lis.get(i);
            int cnt = 0;
            if(money >= cash){
                cnt = money /cash;
                answer.add(cnt);
                money = money - cnt * cash;
            }else{
                answer.add(cnt);
            }
        }
        return answer;
    }
}

