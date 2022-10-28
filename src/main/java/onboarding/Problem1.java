package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (checkError(pobi) || checkError(crong)) {
            return -1;
        }

        return answer;
    }

    static boolean checkError(List<Integer> user) {
        for (Integer page : user) {
            if (page > 400) {
                return true;
            }
        }

        return user.get(1) - user.get(0) != 1;
    }
}