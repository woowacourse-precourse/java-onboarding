package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    public static List<Integer> minimizeWallet(int money){
        Integer[] amountOfMoney = {50000,10000,5000,1000,500,100,50,10,1};
        Integer[] countOfMoney = new Integer[9];
        int checkMoney = money;

        for(int i =0;i<9;i++){
           countOfMoney[i] = checkMoney/amountOfMoney[i];
           checkMoney = money % amountOfMoney[i];
        }
        List<Integer> organizedWallet = Arrays.asList(countOfMoney);

        return organizedWallet;
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        answer = minimizeWallet(money);
        return answer;
    }
}
