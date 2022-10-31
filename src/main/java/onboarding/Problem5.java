package onboarding;

import onboarding.pkgProblem5.service.WithdrawService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 출금하고자 하는 돈을 지폐 및 동전으로 몇개로 변환되는지에 대한 문제
 * @author 유지웅
 */
public class Problem5 {
    public static List<Integer> solution(int money) {
        WithdrawService withdraw = new WithdrawService();

        return withdraw.divideMoney(money);
    }
}
