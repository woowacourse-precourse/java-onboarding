package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static int[] withdraw(int money){
        int oman = money / 50000;
        money = money % 50000;
        int man = money / 10000;
        money = money % 10000;
        int ochun = money / 5000;
        money = money % 5000;
        int chun = money / 1000;
        money = money % 1000;
        int obaek = money / 500;
        money = money % 500;
        int baek = money / 100;
        money = money % 100;
        int osib = money / 50;
        money = money % 50;
        int sib = money / 10;
        int ill = money % 10;

        return new int[]{oman, man,ochun,chun,obaek,baek,osib,sib,ill};
    }
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        return answer;
    }
}
