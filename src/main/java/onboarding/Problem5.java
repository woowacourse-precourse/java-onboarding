package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Money{
    private List<Integer> moneyUnits = Arrays.asList(50000, 10000, 1000, 500, 100, 50, 10, 1); // default 값 한국기준

    public void setMoneyUnits(List<Integer> moneyUnits) {// 단위 변경
        this.moneyUnits = moneyUnits;
    }
}
public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }
}
