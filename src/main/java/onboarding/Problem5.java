package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer  = new ArrayList<Integer>();

        int bill[] = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int tempCnt = 0;
        for(int i = 0; i < 9; i++){
            tempCnt = money / bill[i];
            answer.add(tempCnt);
            money = money - tempCnt * bill[i];
        }
        return answer;
    }
}
