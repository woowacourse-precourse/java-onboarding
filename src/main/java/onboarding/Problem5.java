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

    static List<Integer> change_money(int money){
        List<Integer> result = new ArrayList<>();

        while(money>0){
            if(money>=50000){
                result.add(money/50000);
                money %= 50000;
            }else if(money>=10000){
                result.add(money/10000);
                money %= 10000;
            }else if(money>=5000){
                result.add(money/5000);
                money %= 5000;
            }else if(money>=1000){
                result.add(money/1000);
                money %= 1000;
            }else if(money>=500){
                result.add(money/500);
                money %= 500;
            }else if(money>=100){
                result.add(money/100);
                money %= 100;
            }else if(money>=50){
                result.add(money/50);
                money %= 50;
            }else if(money>=10){
                result.add(money/10);
                money %= 10;
            }else if(money>=1){
                result.add(money/1);
                money %= 1;
            }else System.out.println("자연수가 아닙니다.");
        }

        return result;
    }
}
