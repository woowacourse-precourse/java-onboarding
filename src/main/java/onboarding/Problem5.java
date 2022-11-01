package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();//예외 : Collections.emptyList();
        int temp=money;
        int [] moneys = {50000,10000,5000,1000,500,100,50,10,1};
        int [] size = new int[9];
        for(int i=0; i<moneys.length; i++){
            size[i] = temp / moneys[i];
            temp %= moneys[i];
        }
        for(int i=0; i<size.length; i++){
            answer.add(size[i]);
        }
        return answer;
    }

}
