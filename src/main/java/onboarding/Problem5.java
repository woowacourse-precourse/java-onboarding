package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        int result = 0;
        // 화폐 단위 저장소능 기능
        int[] moneyRepository = new int[9];

        moneyRepository[0] = 50000;
        moneyRepository[1] = 10000;
        moneyRepository[2] = 5000;
        moneyRepository[3] = 1000;
        moneyRepository[4] = 500;
        moneyRepository[5] = 100;
        moneyRepository[6] = 50;
        moneyRepository[7] = 10;
        moneyRepository[8] = 1;


        for (int i=0; i<moneyRepository.length; i++){
            int count = money % moneyRepository[i];
            answer.add(count);
            result += count;
        }


        return answer;
    }



}
