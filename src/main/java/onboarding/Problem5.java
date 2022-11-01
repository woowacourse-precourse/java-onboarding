package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] moneyArr = {50000,10000,5000,1000,500,100,50,10,1};
        int tmp = money;

        for(int i=0;i< 9;i++){
            if(tmp >=moneyArr[i]){
                answer.add(tmp/moneyArr[i]);
                tmp = tmp - moneyArr[i]* answer.get(i);
            }else {
                answer.add(0);
            }
        }
        return answer;
        }

    }


