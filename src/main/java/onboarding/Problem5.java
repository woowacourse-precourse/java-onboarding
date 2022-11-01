package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    public static int[] monetary_unit= {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = monetaryUnitCount(money);

        return answer;
    }

    public static List<Integer> monetaryUnitCount(int money){

        List<Integer> result = new ArrayList<>();

        for(int i=0;i<monetary_unit.length;i++){
            result.add(money/monetary_unit[i]);
            money%=monetary_unit[i];
        }

        return result;
    }
    
}
