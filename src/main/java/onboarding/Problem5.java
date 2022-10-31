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
        for(int i =0; i < 9; i++){
            if(fiveUnit >= 50) divideWithUnit(fiveUnit);
            if(oneUnit >= 1) divideWithUnit(oneUnit);
            oneUnit /= 10;
            fiveUnit /= 10;
        }
    }

    private void divideWithUnit(int unit){
        if(money < unit){
            answer.add(0);
            return;
        }
        int count = 0;
        count += money/unit;
        money -= unit * count;
        answer.add(count);
    }
}
