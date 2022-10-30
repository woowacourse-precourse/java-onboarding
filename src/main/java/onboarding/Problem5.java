package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = withdraw(money);
        return answer;
    }

    private static List<Integer> withdraw(int money) {
        List<Integer> list = new LinkedList();
        int arr[] = {50000,10000,5000,1000,500,100,50,10,1};
        for(int i=0; i<arr.length; i++){
            list.add(money / arr[i]);
            money %= arr[i];

        }
        return list;
    }
}
