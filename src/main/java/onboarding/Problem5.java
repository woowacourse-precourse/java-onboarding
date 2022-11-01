package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> result = new ArrayList<>();


        int moneyList[] = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1}; //화폐 종류
        int count; //개수 카운트 변수

        for(int i=0; i<moneyList.length; i++)
        {
            count = money/moneyList[i]; //몫 = 전환할 수 있는 개수
            money %= moneyList[i]; //나머지 = 전환하고 남은 돈
            result.add(i, count);
        }
        return result;
    }

}
