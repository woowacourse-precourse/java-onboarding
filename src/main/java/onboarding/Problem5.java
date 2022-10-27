package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int Change = 100000;
        int Switch = 2;
        do  {
            Change = (int)Change/Switch;
            Switch = (Switch==5) ? 2 : 5;
            if (Change==5) Change=1;
            answer.add((int)money/Change);
            money = money%Change;
        }while(Change!=1);
        return answer;
    }
}
