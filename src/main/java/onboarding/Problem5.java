package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Problem5 {
    public static List<Integer> change(List<Integer> lst, int target){
        List<Integer> currency = new ArrayList<Integer>(Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1));
        for(int i = 0; i < 9; i++){
            int tmp = target / currency.get(i);
            lst.set(i, tmp);
            target -= lst.get(i) * currency.get(i);
        }
        return lst;
    }
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < 9; i++) {
            answer.add(0);
        }
        return change(answer, money);
    }
}
