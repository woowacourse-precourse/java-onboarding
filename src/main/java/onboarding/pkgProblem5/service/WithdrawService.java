package onboarding.pkgProblem5.service;

import java.util.ArrayList;
import java.util.List;

public class WithdrawService{

    private static final int[] moneyDivision = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    /**
     * 인출하고 싶은 돈을 지폐와 동전으로 나누는 메소드
     * @param money  인출하고 싶은 돈
     * @return 변환된 지폐 및 동전 개수를 가지고 있는 배열
     */
    public List<Integer> divideMoney(int money){
        List<Integer> divided = new ArrayList<>();
        int[] md = moneyDivision;

        for(int i=0; i<md.length; i++) {
            if(money / md[i] <= 0) {
                divided.add(0);
                continue;
            }
            divided.add(money / md[i]);
            money %= md[i];
        }
        return divided;
    }
}
