package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static int[]moneyUnits = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        if (!isValid(money)){
            return new ArrayList<>();   // 조건이 맞지 않으면 빈 리스트를 반환.
        }

        return answer;
    }

    /**
     * 주어진 money가 범위안에 들어가는지 체크하는 메소드
     * @param money
     * @return
     */
    public static boolean isValid(int money){
        return 1 >= money && 1001000000 >= money;
    }


}
