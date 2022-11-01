package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static Integer[] withdraw(int money){
        //5만원권
        int oman = money / 50000;
        money = money % 50000;
        //1만원권
        int man = money / 10000;
        money = money % 10000;
        //5천원권
        int ochun = money / 5000;
        money = money % 5000;
        //1천원권
        int chun = money / 1000;
        money = money % 1000;
        //500원
        int obaek = money / 500;
        money = money % 500;
        //100원
        int baek = money / 100;
        money = money % 100;
        //50원
        int osib = money / 50;
        money = money % 50;
        //10원
        int sib = money / 10;
        //1원
        int ill = money % 10;

        return new Integer[]{oman, man,ochun,chun,obaek,baek,osib,sib,ill};
    }
    public static List<Integer> solution(int money) {
        List<Integer> answer = Arrays.asList(withdraw(money));
        return answer;
    }
}
