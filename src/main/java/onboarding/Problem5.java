package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    static int rest_money;
    public static List<Integer> solution(int money) {
        rest_money = money;
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    public static List<Integer> check_unit_count(){
        int[] money_unit = {50000,10000,5000,1000,500,100,50,10,1};
        List<Integer> unit_count = new ArrayList<Integer>();
        for(int i = 0; i < money_unit.length; i++){
            int unit = money_unit[i];
            int count = counting(unit);
            unit_count.add(count);
        }
        return unit_count;
    }

    public static int counting(int unit){
        int count = rest_money / unit;
        rest_money = rest_money % unit;
        return count;
    }
}
