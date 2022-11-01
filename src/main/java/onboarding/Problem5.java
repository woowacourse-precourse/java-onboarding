package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        if(money>=50000) {answer.add(fifty_thous(money)); money %= 50000;}
        else answer.add(0);

        if(money>=10000) {answer.add(ten_thous(money)); money %= 10000;}
        else answer.add(0);

        if(money>=5000) {answer.add(five_thous(money)); money %= 5000;}
        else answer.add(0);

        if(money>=1000) {answer.add(thous(money)); money %= 1000;}
        else answer.add(0);

        if(money>=500) {answer.add(five_hund(money)); money %= 500;}
        else answer.add(0);

        if(money>=100) {answer.add(hund(money)); money %= 100;}
        else answer.add(0);

        if(money>=50) {answer.add(fifty(money)); money %= 50;}
        else answer.add(0);

        if(money>=10) {answer.add(ten(money)); money %= 10;}
        else answer.add(0);

        if(money>=1) {answer.add(one(money));}
        else answer.add(0);


        return answer;
    }

    static int fifty_thous(int money){
        return money/50000;
    }

    static int ten_thous(int money){
        return money/10000;
    }

    static int five_thous(int money){
        return money/5000;
    }

    static int thous(int money){
        return money/1000;
    }

    static int five_hund(int money){
        return money/500;
    }

    static int hund(int money){
        return money/100;
    }

    static int fifty(int money){
        return money/50;
    }

    static int ten(int money){
        return money/10;
    }

    static int one(int money){
        return money/1;
    }

}
