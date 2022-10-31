package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {

        List<Integer> answer = new ArrayList<>();
        int[] currency = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        Chaneger(currency,answer,money);//돈 단위에 맞는 갯수 나누는 함수

        return answer;
    }
    public static  void  Chaneger(int[] currency, List<Integer> change, int money)
    {
        for(int curr:currency)
        {
            change.add(money/curr);
            money%=curr;
        }
    }
}
