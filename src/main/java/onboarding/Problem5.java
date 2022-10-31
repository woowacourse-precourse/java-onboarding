package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();

        counting(answer,money);
        return answer;
    }
    static void counting(List<Integer> count, int money){
        //save the money list
        int[] lists = {50000,10000,5000,1000,500,100,50,10,1};
        //compute count money
        for(int i = 0; i < 9; i++){
            if(money > lists[i]){
                count.add(money/lists[i]);
                money = money % lists[i];
            }
            else{
                count.add(0);
            }
        }
    }
}
