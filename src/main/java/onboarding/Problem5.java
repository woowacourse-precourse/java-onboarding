package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {

        int[] answer = new int[9];
        int[] sort_money = new int[]{50000,10000,5000,1000,500,100,50,10,1};

        for(int i = 0; i<sort_money.length; i++){
            if(i==0){
                answer[i] = (money / sort_money[i]);

            }else {
                answer[i] = (money % sort_money[i - 1]) / sort_money[i];
            }
        }
        List<Integer> list = new ArrayList<>(answer.length);
        for (int num : answer) {
            list.add(num);
        }
        return list;
    }
}