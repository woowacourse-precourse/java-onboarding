package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        answer = splitMoney(won(),money);


        return answer;
    }

    public static int[] won(){
        return new int[]{50000,10000,5000,1000,500,100,50,10,1};
    }

    public static ArrayList<Integer> splitMoney(int [] won, int money){
        ArrayList<Integer> splitMoney = new ArrayList<>();
        for(int i = 0; i<won.length; i++){
            splitMoney.add(money/won[i]);
            money %= won[i];
        }return splitMoney;
    }
}


