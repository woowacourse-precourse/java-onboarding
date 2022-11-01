package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        Wallet.validateOutOfRange(money);
        return Wallet.pay(money);
    }
}
class Wallet{
    private static final int LOWER_BOUND_LIMIT = 1;
    private static final int UPPER_BOUND_LIMIT = 1000000;
    private static final String OUT_OF_RANGE = "1이상 1,000,000이하의 금액를 입력해 주세요";
    static int[] cate = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    static List<Integer> pay(int money){
        List<Integer> answer = new ArrayList<>();
        for (int bill : cate) {
                int coinCnt = money / bill;
                answer.add(coinCnt);
                money -= bill * coinCnt;
        }
        return answer;
    }

    public static void validateOutOfRange(int money) {
        if(money < LOWER_BOUND_LIMIT || money > UPPER_BOUND_LIMIT)
            throw new IllegalArgumentException(OUT_OF_RANGE);
    }
}
