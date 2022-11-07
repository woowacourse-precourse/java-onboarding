package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int [] tmp = {50000,10000,5000,1000,500,100,50,10,1};

        for (int i = 0; i<9;i++){
            if(money/tmp[i]>0){
                answer.add(Integer.valueOf(money / tmp[i]));
                money%=tmp[i];
            }
            else{
                answer.add(0);
            }
        }

        return answer;
    }
}
