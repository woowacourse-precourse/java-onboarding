package onboarding;

import java.util.Iterator;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;
        return answer;
    }

    private static int getBestPageScore(List<Integer> pages) {
        Iterator<Integer> iterator = pages.iterator();
        int returnValue = Integer.MIN_VALUE;
        while(iterator.hasNext()) {
            int page = iterator.next();
            int now = Problem1.getScore(page);
            if(returnValue < now) {
                returnValue = now;
            }
        }
        return returnValue;
    }

    private static int getScore(int page) {
        int[] target = {0, 1};
        while(page > 0) {
            target[0] += (page % 10);
            target[1] *= (page % 10);
            page /= 10;
        }
        return Math.max(target[0], target[1]);
    }
}