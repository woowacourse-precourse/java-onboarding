package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {

        List<Integer> intArr = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        List<Integer> answer = new ArrayList<>();

        for(int i=0; i<intArr.size(); i++){
            int result = money/intArr.get(i);
            if( result!=0 ){
                answer.add(result);
                money -= result*(intArr.get(i));
            } else{
                answer.add(0);
            }
        }
        return answer;
    }
}
