package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static int check(int count){
        if(count > 0)
            return count;
        else
            return 0;
    }
    public static List<Integer> solution(int money) {
        int count;
        int digitNum = Integer.toString(money).length();
        ArrayList answer = new ArrayList();
        count = money / 50000;
        if(count > 0) {
            answer.add(count);
            System.out.println(money);
            if(money % 50000 == 0)
                money = money % (int)(Math.pow(10, Integer.toString(money).length() - 1));
            else
                money = money % 50000;
            System.out.println(money);
        }
        else
            answer.add(0);

        count = money / 10000;
        if(count > 0){
            answer.add(count);
            money = money % (int)(Math.pow(10, Integer.toString(money).length() - 1));
        }
        else
            answer.add(0);

        count = money / 5000;
        if(count > 0){
            answer.add(count);
            if(money % 5000 == 0)
                money = money % (int)(Math.pow(10, Integer.toString(money).length() - 1));
            else
                money = money % 5000;
        }
        else
            answer.add(0);

        count = money / 1000;
        if(count > 0){
            answer.add(count);
            money = money % (int)(Math.pow(10, Integer.toString(money).length() - 1));
        }
        else
            answer.add(0);

        count = money / 500;
        if(count > 0){
            answer.add(count);
            if(money % 500 == 0)
                money = money % (int)(Math.pow(10, Integer.toString(money).length() - 1));
            else
                money = money % 500;
        }
        else
            answer.add(0);

        count = money / 100;
        if(count > 0){
            answer.add(count);
            money = money % (int)(Math.pow(10, Integer.toString(money).length() - 1));
        }
        else
            answer.add(0);

        count = money / 50;
        if(count > 0){
            answer.add(count);
            if(money % 50 == 0)
                money = money % (int)(Math.pow(10, Integer.toString(money).length() - 1));
            else
                money = money % 50;
        }
        else
            answer.add(0);

        count = money / 10;
        if(count > 0){
            answer.add(count);
            money = money % (int)(Math.pow(10, Integer.toString(money).length() - 1));
        }
        else
            answer.add(0);


        count = money / 1;
        if(count > 0){
            answer.add(count);
        }
        else
            answer.add(0);

        return answer;
    }
}
