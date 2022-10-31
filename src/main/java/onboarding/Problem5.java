package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    int money;
    List<Integer> answer =new ArrayList<>();
    public static List<Integer> solution(int money) {
        Problem5 p5 = new Problem5();
        p5.money = money;
        p5.iterate();
        return p5.answer;
    }

    private void iterate() {
        int fiveUnit = 50000;
        int oneUnit = 10000;
        System.out.println(money);
        while(money > 0){
            divideFiveUnit(fiveUnit);
            if(fiveUnit > 5) fiveUnit /= 10;
        }
    }

    private void divideFiveUnit(int unit){
        if(money < unit) return;
        int count = 0;
        count += money/unit;
        money -= unit;
        answer.add(count);
    }
}
