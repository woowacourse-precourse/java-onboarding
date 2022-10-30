package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        answer = Bill(money);

        return answer;
    }
    public static List<Integer> Bill(int money){
        List<Integer> sol = new ArrayList<Integer>();
        int[] bill = new int[]{50000,10000,5000,1000,500,100,50,10,1};

        for(int i = 0 ; i < bill.length ; i++){
            System.out.println(money+" "+money/bill[i]);

            sol.add(money/bill[i]);
            money = (money % bill[i]);
        }
        System.out.println(money);

        return sol;
    }
}
