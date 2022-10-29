package onboarding;

import java.util.*;

public class Problem5 {
    public static List<Integer> solution(int money) {

        List<Integer> moneyValList = Arrays.asList(50000,10000,5000,1000,500,100,50,10,1);
        List<Integer> wallet = new ArrayList<>(Collections.nCopies(9, 0));
        int index = 0;

        while(money > 0) {

            wallet.set(index,money / moneyValList.get(index));
            money %= moneyValList.get(index);
            index++;
        }

        return wallet;
    }

}
