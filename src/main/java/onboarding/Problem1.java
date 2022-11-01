package onboarding;

import java.util.List;

class Problem1 {
    public static boolean isException(List<Integer> pobi, List<Integer> crong)
    {
        if (pobi.size() != 2 || crong.size() != 2)
            return true;
        for (Integer page : pobi)
            if (page < 1 || page > 400)
                return true;
        for (Integer page : crong)
            if (page < 1 || page > 400)
                return true;
        return false;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}