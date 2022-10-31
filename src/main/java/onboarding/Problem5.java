package onboarding;

import java.util.*;

public class Problem5 {
    private static int func(int money, int unit, List<Integer> list){
        int cnt = 0;
        while(money >= unit){
            money -= unit;     cnt++;
        }
        list.add(cnt);
        return money;
    }
    public static List<Integer> solution(int money) {
        List<Integer> list = new LinkedList<>();
        int[] units = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for(int unit : units)
            money = func(money, unit, list);

        return list;
    }
}
