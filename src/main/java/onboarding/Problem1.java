package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static boolean handleException(List<Integer> user) {

        // 왼쪽이 홀수가 아닌 경우
        if (user.get(0) % 2 == 0) {
            return true;
        }

        // 펼친 페이지가 연속된 페이지가 아닌 경우
        if (user.get(1) - user.get(0) != 1) {
            return true;
        }

        // 펼친 페이지가 3 ~ 398 사이가 아닌 경우 (1 ~ 400 페이지 중 시작 면과 마지막 면 제외)
        if ((3 > user.get(0) || user.get(0) > 398) || (3 > user.get(1) || user.get(1) > 398)) {
            return true;
        }

        return false;
    }

    public static int getMaxScore(List<Integer> user) {
        int sum = 0;
        int mul = 1;
        int num = 0;
        List<Integer> scores = new ArrayList<>();

        for (Integer page : user) {
            sum = 0;
            mul = 1;
            num = page;

            while (num != 0) {
                sum += num % 10;
                mul *= num % 10;
                num /= 10;
            }
            scores.add(sum);
            scores.add(mul);
        }

        int maxScore = scores.get(0);
        for (int i = 1; i < scores.size(); i++) {
            if (maxScore < scores.get(i)) maxScore = scores.get(i);
        }

        return maxScore;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiScore = getMaxScore(pobi);
        int crongScore = getMaxScore(crong);

        if (handleException(pobi) || handleException(crong)) {
            answer = -1;
        } else if (pobiScore > crongScore) {
            answer = 1;
        } else if (pobiScore < crongScore) {
            answer = 2;
        } else {
            answer = 0;
        }

        return answer;
    }
}