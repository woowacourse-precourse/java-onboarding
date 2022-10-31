package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int a = money/50000;
        int b = (money%50000)/10000;
        int c = ((money%50000)%10000)/5000;
        int d = (((money%50000)%10000)%5000)/1000;
        int e = ((((money%50000)%10000)%5000)%1000)/500;
        int f = (((((money%50000)%10000)%5000)%1000)%500)/100;
        int g = ((((((money%50000)%10000)%5000)%1000)%500)%100)/50;
        int h = (((((((money%50000)%10000)%5000)%1000)%500)%100)%50)/10;
        int i = (((((((money%50000)%10000)%5000)%1000)%500)%100)%50)%10;

        List<Integer> answer = List.of(a, b, c, d, e, f, g, h, i);

        return answer;
    }
}
