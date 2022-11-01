package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int a = money/50000;
        int a1 = money%50000;
        int b = a1/10000;
        int b1 = money%10000;
        int c = b1/5000;
        int c1 = money%5000;
        int d = c1/1000;
        int d1 = money%1000;
        int e = d1/500;
        int e1 = money%500;
        int f = e1/100;
        int f1 = money%100;
        int g = f1/50;
        int g1 = money%50;
        int h = g1/10;
        int h1 = money%10;
        int i = h1/1;

        List<Integer> answer = new ArrayList<>(Arrays.asList(a,b,c,d,e,f,g,h,i));
        return answer;
    }


}
