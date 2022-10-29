package onboarding;

import java.util.List;

import onboarding.problem5.BillConverter;

public class Problem5 {
    public static List<Integer> solution(int money) {
        BillConverter billConverter = new BillConverter();

        List<Integer> answer = billConverter.convertIntoBills(money);

        return answer;
    }
}
