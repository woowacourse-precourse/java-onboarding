package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    public static int calculate(int price, int divide, int index, List<Integer> answer) {
        int a = 0;
        if ((a = price / divide) != 0) {
            answer.set(index, a);
            price -= divide * a;
        }
        return price;
    }
    public static List<Integer> solution(int money) {
        List<Integer> answer=new ArrayList<>();
        for(int i=0;i<9;i++)
            answer.add(0);

        money=calculate(money,50000,0,answer);
        money=calculate(money,10000,1,answer);
        money=calculate(money,5000,2,answer);
        money=calculate(money,1000,3,answer);
        money=calculate(money,500,4,answer);
        money=calculate(money,100,5,answer);
        money=calculate(money,50,6,answer);
        money=calculate(money,10,7,answer);

        answer.set(8,money);

        return answer;
    }
}
