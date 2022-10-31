package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> monetaryUnit= List.of(50000,10000,5000,1000,500, 100, 50,10, 1);

        int monetaryUnitLength = monetaryUnit.toArray().length;
        List<Integer> answer = new ArrayList(Collections.nCopies(monetaryUnitLength,0));

        for(int i =0; i< monetaryUnitLength; i++){
            int count = (int)(money / monetaryUnit.get(i));
            answer.set(i, count);
            money %= monetaryUnit.get(i);
        }
        return answer;
    }

}
