package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] divisor={50000,10000,5000,1000,500,100,50,10,1};

        for(int i = 0; i< divisor.length; i++){
            Integer cnt= money/divisor[i];
            answer.add(cnt);
            money%=divisor[i];
        }
        return answer;
    }

}
