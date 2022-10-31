package onboarding;

import java.util.*;
/*
50000 10000 5000 1000 500 100 50 10 1
 */

public class Problem5 {
    static List<Integer> Cut_the_money(int money){
        int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> num = new ArrayList<Integer>();
        for(int i = 0 ; i < unit.length ; i++ ){
            num.add(money / unit[i]);
            money = money % unit[i];
        }
        return num;
    }
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = Cut_the_money(money);
        System.out.println(answer);
        return answer;
    }
}
