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

        if(pages.size() != 2) throw new Exception("pobi와 crong의 길이는 2가 되어야 합니다.");

        Iterator<Integer> iterator = pages.iterator();
        int left = iterator.next();
        int right = iterator.next();

        if(Math.abs(left - right) > 1) throw new Exception("pobi와 crong에는 [왼쪽 페이지 번호, 오른쪽 페이지 번호]가 순서대로 들어있어야 합니다.");

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