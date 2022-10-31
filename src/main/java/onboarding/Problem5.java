package onboarding;

import java.util.*;

public class Problem5 {
    public static ArrayList<Integer> solution(int money) {
        ArrayList<Integer>l = new ArrayList<>();
        if(money >= 1 && money <=1000000){
            l.add(money/50000);
            l.add((money%50000)/10000);
            l.add(((money%50000)%10000)/5000);
            l.add((((money%50000)%10000)%5000)/1000);
            l.add(((((money%50000)%10000)%5000)%1000)/500);
            l.add((((((money%50000)%10000)%5000)%1000)%500)/100);
            l.add(((((((money%50000)%10000)%5000)%1000)%500)%100)/50);
            l.add((((((((money%50000)%10000)%5000)%1000)%500)%100)%50)/10);
            l.add((((((((money%50000)%10000)%5000)%1000)%500)%100)%50)%10);

            return l;
        }
        else return null;
    }
}
