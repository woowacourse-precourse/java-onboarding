package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    //자리수 구분해 리스트에 넣음
    public static List<Integer> digit(int money)
    {
        List<Integer> digitNumber = new ArrayList<>();

        while (money >= 0)
        {
            digitNumber.get(money % 10);
            money /= 10;
        }
        return digitNumber;
    }
    public static void divisionMoney(int money)
    {

    }
}
