package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(8);
        getCountBill(answer, money);
        return answer;
    }

    public static void getCountBill(List<Integer> answer, int money){
        List<Integer> billList = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        int tmp = money;
        for(int bill : billList) {
            answer.add(tmp / bill);
            tmp %= bill;
        }
    }
}
