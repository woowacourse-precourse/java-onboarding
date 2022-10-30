package onboarding;

import onboarding.problem5.objects.Bank;
import onboarding.problem5.objects.Money;
import onboarding.problem5.objects.MoneyUnitCounter;
import onboarding.problem5.objects.MoneyValidation;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        try {
            Bank bank = new Bank(new Money(money, new MoneyUnitCounter()));
            List<Integer> result = bank.withdraw();

            return result;
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

            return Collections.emptyList();
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(50237));
    }
}
