package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        // input money is 1~1,000,000
        // goal is to minimize the total number of the content in the answer
        // to minimize the number of the money, must pick a higher value of money.
        // lower the index, higher the value
        // index : money value / 0:50,000 / 1:10,000 / 2:5,000 / 3:1,000 / 4:500 / 5:100 / 6:50 / 7:10 / 8:1
        List<Integer> answer = new ArrayList<Integer>();
        int[] money_type = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1 }; // type of money you can have
        for(int i = 0; i < 9; i++){
            int number_of_money = money / money_type[i];
            money = money % money_type[i];
            answer.add(number_of_money);
        }
        return answer;
    }
}
