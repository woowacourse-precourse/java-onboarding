package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int[] units = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> ans = new ArrayList<Integer>();

        //큰 단위부터 작은 단위로의 순서대로 최대로 가능한만큼 받는다.
        for(Integer unit: units){
            ans.add(money/unit);
            money %= unit;
        }

        return ans;
    }
}
