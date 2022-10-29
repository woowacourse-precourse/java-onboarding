package onboarding;

import java.util.ArrayList;
import java.util.List;

import onboarding.problem5.BillConverter;
import onboarding.problem5.exception.MoneyOutOfRangeException;

public class Problem5 {
    public static List<Integer> solution(int money) {
        try {
            if (money < 1 || 1_000_000 < money) {
                throw new MoneyOutOfRangeException("Amount of money is out of range.");
            }

            BillConverter billConverter = new BillConverter();

            List<Integer> answer = billConverter.convertIntoBills(money);

            return answer;
        } catch (MoneyOutOfRangeException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
