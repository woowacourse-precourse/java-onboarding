package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {

        int[] priceList = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        List<Integer> answer = Collections.emptyList();
        return answer;
    }


    public static int[] count(int[] priceList, int totalMoney) {
        int[] countList = {0, 0, 0, 0, 0, 0, 0, 0, 0};

        int money = totalMoney;

        for (int i = 0; i < countList.length; i++) {
            countList[i] = money / priceList[i];
            money = money % priceList[i];
        }

        return countList;
    }

}
