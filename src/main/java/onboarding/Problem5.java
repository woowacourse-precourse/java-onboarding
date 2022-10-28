package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();
        List<Integer> unit = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

        //제일 큰 금액의 화폐부터 필요한 개수를 차례대로 계산
        //큰 금액의 화폐를 계산하고 남은 돈으로 그 다음 큰 금액의 화폐가 필요한 개수를 계산하기를 반복
        for(int i = 0; i < unit.size(); i++){
            int count = countNumberOfBills(unit.get(i), money);
            answer.add(count);
            money -= unit.get(i)*count; //잔돈 계산
        }

        return answer;
    }

    private static int countNumberOfBills(int unit, int money){
        int count = 0;
        if(money >= unit){
            count = money/unit;
        }
        return count;
    }

}
