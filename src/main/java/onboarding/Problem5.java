package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();

        // 리스트 초기화
        for(int i=0; i<9; i++)
            answer.add(i, 0);

        // greedy하게 큰 금액 위주로 count하고 answer 리스트 값을 수정
        while(money > 0){

            if(money >= 50000){                 // 5만원 이상일경우
                int count = answer.get(0);
                count++;
                answer.set(0, count);
                money -= 50000;
            }
            else if(money >= 10000){            // 만원 이상 5만원 미만
                int count = answer.get(1);
                count++;
                answer.set(1, count);
                money -= 10000;
            }
            else if(money >= 5000){             // 오천원 이상 만원 미만
                int count = answer.get(2);
                count++;
                answer.set(2, count);
                money -= 5000;
            }
            else if(money >= 1000){             // 천원 이상 오천원 미만
                int count = answer.get(3);
                count++;
                answer.set(3, count);
                money -= 1000;
            }
            else if(money >= 500){              // 오백원 이상 천원 미만
                int count = answer.get(4);
                count++;
                answer.set(4, count);
                money -= 500;
            }
            else if(money >= 100){              // 백원 이상 오백원 미만
                int count = answer.get(5);
                count++;
                answer.set(5, count);
                money -= 100;
            }
            else if(money >= 50){               // 오십원 이상 백원 미만
                int count = answer.get(6);
                count++;
                answer.set(6, count);
                money -= 50;
            }
            else if(money >= 10){               // 십원 이상 오십원 미만
                int count = answer.get(7);
                count++;
                answer.set(7, count);
                money -= 10;
            }
            else{                               // 일원 이상 십원 미만
                int count = answer.get(8);
                count++;
                answer.set(8, count);
                money -= 1;
            }
        }

        return answer;
    }
}
