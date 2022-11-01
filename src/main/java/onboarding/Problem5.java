package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {

    private static final int[] monetary_unit_array = {50000,10000,5000,1000,500,100,50,10,1};
    private int[] number_of_monetary_units_used_array = new int[9];
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    private void countUsesPerMonetaryUnit(int monetary_unit_idx, int money){

        if(money==0){
            return;
        }

        if(money<monetary_unit_array[monetary_unit_idx]) {
            countUsesPerMonetaryUnit(monetary_unit_idx+1,money);
        }else {
            number_of_monetary_units_used_array[monetary_unit_idx] = money / monetary_unit_array[monetary_unit_idx];
            countUsesPerMonetaryUnit(monetary_unit_idx+1,money % monetary_unit_array[monetary_unit_idx]);
        }
    }
}
