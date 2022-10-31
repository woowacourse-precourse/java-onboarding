package onboarding;

import java.util.List;

import static java.lang.Math.abs;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;
        if (abs(pobi.get(0) - pobi.get(1)) != 1 || abs(crong.get(0) - crong.get(1)) != 1) {
            return -1;
        }

        return answer;
    }
}