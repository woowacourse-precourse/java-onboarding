package onboarding;

import java.util.List;

import static java.lang.Math.abs;
import static java.lang.Math.max;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;
        if (abs(pobi.get(0) - pobi.get(1)) != 1 || abs(crong.get(0) - crong.get(1)) != 1) {
            return -1;
        }

        return answer;
    }

    private static int calPage(String page) {
        int add = 0, mul = 1;
        for (int i = 0; i < page.length(); i++) {
            add += Character.getNumericValue(page.charAt(i));
            mul *= Character.getNumericValue(page.charAt(i));
        }
        return max(add, mul);
    }

}