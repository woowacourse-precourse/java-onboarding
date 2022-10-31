package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {

        List<Integer> answer = new ArrayList<>();

        while (0 < money){

            if(money > 50000){
                answer.add(money / 50000);
                money = money % 50000;
            }
            else{
                answer.add(0);
            }

            if(money >= 10000){
                answer.add(money / 10000);
                money = money % 10000;
            }
            else{
                answer.add(0);
            }

            if(money >= 5000){
                answer.add(money / 5000);
                money = money % 5000;
            }
            else{
                answer.add(0);
            }

            if(money >= 1000){
                answer.add(money / 1000);
                money = money % 1000;
            }
            else{
                answer.add(0);
            }

            if(money >= 500){
                answer.add(money / 500);
                money = money % 500;
            }
            else{
                answer.add(0);
            }

            if(money >= 100){
                answer.add(money / 100);
                money = money % 100;
            }
            else{
                answer.add(0);
            }

            if(money >= 50){
                answer.add(money / 50);
                money = money % 50;
            }
            else{
                answer.add(0);
            }

            if(money >= 10){
                answer.add(money / 10);
                money = money % 10;
            }
            else{
                answer.add(0);
            }

            if(money > 0){
                answer.add(money);
                money = money % 1;
            }
            else{
                answer.add(0);
            }

        }

        return answer;
    }

}
