package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    public static ArrayList<Integer> countMoney(int money){
        ArrayList<Integer> result = new ArrayList<>();
        int[] moneyList = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for(int i = 0; i < moneyList.length; i++){
            result.add(money/moneyList[i]);
            money %= moneyList[i];
        }
        return result;
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = countMoney(money);
        return answer;
    }
}
