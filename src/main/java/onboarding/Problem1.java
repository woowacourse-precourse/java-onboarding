package onboarding;

import java.util.List;

public class Problem1 {
    private static Integer getMaxValue(List<Integer> user) {
        Integer max = -1;
        for(Integer page : user) {
            int sum = 0;
            int mult = 1;
            while (page > 0) {
                sum += (page % 10);
                mult *= (page % 10);
                page /= 10;
            }
            max = Math.max(sum, mult);
        }
        return max;
    }
    private static boolean validateUser(List<Integer> user) {
        return user.size() == 2 && (user.get(1) - user.get(0) == 1);
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!(validateUser(pobi) && validateUser(crong)))
            return -1;
        int diff = getMaxValue(pobi) - getMaxValue(crong);
        if (diff > 0) {
            return 1;
        } else if (diff < 0) {
            return 2;
        } else {
            return 0;
        }
    }
}