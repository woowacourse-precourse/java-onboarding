package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
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

}
