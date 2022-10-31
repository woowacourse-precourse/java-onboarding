package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Problem5 {
    public static List<Integer> solution(int money) {

        ArrayList<Integer> answer = new ArrayList<Integer>();
        int unit = 50000;
        while(true){
            if((money / unit) >= 1){
                answer.add(money/unit);
                money -= unit * (money/unit);
            }
            else{
                answer.add(0);
            }

            unit /= 5;

            if((money / unit) >= 1){
                answer.add(money/unit);
                money -= unit * (money/unit);
            }
            else{
                answer.add(0);
            }

            if(unit ==10){
                break;
            }
            unit /= 2;
        }
        answer.add(money);


        System.out.println(answer);
        return answer;
    }
}
