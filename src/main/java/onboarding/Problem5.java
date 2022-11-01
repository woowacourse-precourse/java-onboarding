package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    private static final int[] monetary_unit_array = {50000,10000,5000,1000,500,100,50,10,1};
    private int[] number_of_monetary_units_used_array = new int[9];
    public static List<Integer> solution(int money) {
        Problem5 problem5 = new Problem5();

        List<Integer> answer = new ArrayList<>();

        problem5.countUsesPerMonetaryUnit(0,money);

        for(Integer value : problem5.number_of_monetary_units_used_array){
            answer.add(value);
        }

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
