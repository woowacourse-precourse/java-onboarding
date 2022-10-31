package onboarding;

import java.util.List;

class Problem1 {
    private static boolean checkPage(int[] pages) {
        if (pages[0] - pages[1] != -1)
            return false;
        if (pages[0] < 1 || pages[1] > 400)
            return false;
        return true;
    }
    
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!checkPage(pobi) || !checkPage(crong))
            return -1;
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}