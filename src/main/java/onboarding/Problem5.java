package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static int [] splitMoney(int money) {
        int [] billList = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int [] result = new int[9];
        int remainMoney = money;

        for(int i = 0 ; i < billList.length ; i++) {
            int count = remainMoney / billList[i];
            remainMoney = remainMoney - count * billList[i];
            result[i] = count;
        }

        return result;
    }

    public static boolean checkInput(int money) {
        if(money < 1 || money > 1000000) {
            return false;
        }

        return true;
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        if(!checkInput(money)) {
            return answer;
        }

        answer = new ArrayList<>();
        for(int element : splitMoney(money)) {
            answer.add(element);
        }

        return answer;
    }
}
