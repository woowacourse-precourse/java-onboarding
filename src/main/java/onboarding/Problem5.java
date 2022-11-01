package onboarding;

import java.util.List;
import java.util.ArrayList;

public class Problem5 {
    public static int ConvertMoney(int money, int target){
        return money/target;
    }
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();

        int[] pivot = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for(int i=0;i<pivot.length;i++){
            answer.add(ConvertMoney(money, pivot[i]));
            money -= (money/pivot[i]) * pivot[i];
        }
        return answer;
    }
}
