package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    public static List<Integer> moneyToCurrency(int money){
        ArrayList<Integer> currencyList = new ArrayList<>();
        int[] availableCurrency = {50000,10000,5000,1000,500,100,50,10,1};

        for(int i=0; i<availableCurrency.length; i++){
            currencyList.add(money / availableCurrency[i]);
            money %= availableCurrency[i];
        }
        return currencyList;
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = moneyToCurrency(money);
        return answer;
    }
}
