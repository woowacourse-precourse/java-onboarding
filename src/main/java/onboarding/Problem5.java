package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        for(int i=0; i<9; i++)
            answer.add(i, 0);

        while(money > 0){
            //count = 0;
            if(money >= 50000){
                int count = answer.get(0);
                count++;
                answer.set(0, count);
                money -= 50000;
            }
            else if(money >= 10000){
                int count = answer.get(1);
                count++;
                answer.set(1, count);
                money -= 10000;
            }
            else if(money >= 5000){
                int count = answer.get(2);
                count++;
                answer.set(2, count);
                money -= 5000;
            }
            else if(money >= 1000){
                int count = answer.get(3);
                count++;
                answer.set(3, count);
                money -= 1000;
            }
            else if(money >= 500){
                int count = answer.get(4);
                count++;
                answer.set(4, count);
                money -= 500;
            }
            else if(money >= 100){
                int count = answer.get(5);
                count++;
                answer.set(5, count);
                money -= 100;
            }
            else if(money >= 50){
                int count = answer.get(6);
                count++;
                answer.set(6, count);
                money -= 50;
            }
            else if(money >= 10){
                int count = answer.get(7);
                count++;
                answer.set(7, count);
                money -= 10;
            }
            else{
                int count = answer.get(8);
                count++;
                answer.set(8, count);
                money -= 1;
            }
        }

        return answer;
    }
}
