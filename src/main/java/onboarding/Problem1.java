package onboarding;

import java.util.List;

class Problem1 {
    public static boolean isException(List<Integer> pobi, List<Integer> crong)
    {
        for (Integer page : pobi)
            if (page < 1 || page > 400)
                return true;
        for (Integer page : crong)
            if (page < 1 || page > 400)
                return true;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}