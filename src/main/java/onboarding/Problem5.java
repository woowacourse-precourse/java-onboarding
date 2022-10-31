package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int count = 0;
        // 오만원
        if(money < 50000){
            answer.add(count);
        }
        else if(money >= 50000){
            while(money >= 50000){
                money -= 50000;
                count += 1;
            }
            answer.add(count);
            count = 0;
        }
        // 일만원
        if(money < 10000){
            answer.add(count);
        }
        else if (money >= 10000){
            while(money >= 10000){
                money -= 10000;
                count += 1;
            }
            answer.add(count);
            count = 0;
        }
        // 오천원
        if(money < 5000){
            answer.add(count);
        }
        else if (money >= 5000){
            while(money >= 5000){
                money -= 5000;
                count += 1;
            }
            answer.add(count);
            count = 0;
        }
        // 일천원
        if(money < 1000){
            answer.add(count);
        }
        else if(money >= 1000){
            while(money >= 1000){
                money -= 1000;
                count += 1;
            }
            answer.add(count);
            count = 0;
        }
        // 오백원
        if(money < 500){
            answer.add(count);
        }
        else if(money >= 500){
            while(money >= 500){
                money -= 500;
                count += 1;
            }
            answer.add(count);
            count = 0;
        }
        // 일백원
        if(money < 100){
            answer.add(count);
        }
        else if(money >= 100){
            while(money >= 100){
                money -= 100;
                count += 1;
            }
            answer.add(count);
            count = 0;
        }
        // 오십원
        if(money < 50){
            answer.add(count);
        }
        else if(money >= 50){
            while(money >= 50){
                money -= 50;
                count += 1;
            }
            answer.add(count);
            count = 0;
        }
        // 일십원
        if(money < 10){
            answer.add(count);
        }
        else if(money >= 10){
            while(money >= 10){
                money -= 10;
                count += 1;
            }
            answer.add(count);
            count = 0;
        }
        // 일원
        if(money < 1){
            answer.add(count);
        }
        else if(money > 0){
            while(money > 0){
                money -= 1;
                count += 1;
            }
            answer.add(count);
            count = 0;
        }
        return answer;
    }
}
