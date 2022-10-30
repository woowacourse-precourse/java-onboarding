package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer=ListInMoneyCount(money);
        return answer;
    }

    /**
     * 지폐수를 세어주는 method
     *
     * @param money 입력 돈
     * @param moneyUnit 단위
     * @return 카운트 된 값
     */
    public static int moneyCount(int money,int moneyUnit)
    {
        int count =0;
        if(money>=moneyUnit)
        {
            count=money/moneyUnit;
        }
        return count;
    }

    /**
     * if횟수를 줄여본 리스트에 담는 머니카운트
     *
     * else if 작업을 줄여보았습니다.
     * @param money 입력 돈
     * @return answer
     */
    public static List<Integer> ListInMoneyCount (int money)
    {
        int moneyUnits[] = {50000,10000,5000,1000,500,100,50,10,1};
        List<Integer> answer = new ArrayList<>();
        for (int moneyUnit : moneyUnits) {
            int count = moneyCount(money, moneyUnit);
            answer.add(count);
            money=money-(moneyUnit*count);
        }
        return answer;
    }
}
