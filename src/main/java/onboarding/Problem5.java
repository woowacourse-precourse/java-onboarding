package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    // 50000원, 10000원 ,5000원, 1000원, 500원, 100원, 50원, 10원, 1원
    public static List<Integer> solution(int money) {
        List<Integer> pocket = new ArrayList<>(8);
        int standard[] = {50000, 10000 ,5000, 1000, 500, 100, 50, 10, 1};
        int length = (int)(Math.log10(money)+1);
        int re = money ;
        for(int i = 0; i <= 8 ; i++){
            pocket.add(re / (standard[i]));
            re -= (re / (standard[i])) * (standard[i]);
        }
        return pocket;
    }
    public static void main(String args[]){
        System.out.println(solution(50237));
    }

}
