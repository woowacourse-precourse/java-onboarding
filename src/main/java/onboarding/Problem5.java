package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();

        Integer[] moneyList = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        if (money >= 1 || money < 1000000) {
            for (int i = 0; i < moneyList.length; i++){
                Integer c = money / moneyList[i];
                if (c > 0){
                    answer.add(c);
                } else {
                    answer.add(0);
                }
                money %= moneyList[i];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(15000));
    }
}
