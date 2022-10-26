package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(validation(pobi) == -1 || validation(crong) == -1) {
            return -1;
        }

        return answer;
    }

    public static int validation(List<Integer> page) {
        if(page.get(0) == 1 || page.get(1) == 400) {
            return -1;
        }
        if(page.get(0) + 1 != page.get(1)) {
            return -1;
        }
        return 0;
    }
}

