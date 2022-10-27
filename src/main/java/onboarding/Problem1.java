package onboarding;

import java.util.Iterator;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;
        try {
            int pobiScore = getBestPageScore(pobi);
            int crongScore = getBestPageScore(crong);

            if(pobiScore > crongScore) answer += 1;
            else if(pobiScore < crongScore) answer += 2;
            
        } catch (Exception e) {
            answer -=1;
        }

        return answer;
    }

    private static int getBestPageScore(List<Integer> pages) throws Exception {
        Iterator<Integer> iterator = pages.iterator();
        int left = iterator.next();
        int right = iterator.next();

        if(Math.abs(left - right) > 1) throw new Exception("예외발생");

        return Math.max(getScore(left), getScore(right));

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