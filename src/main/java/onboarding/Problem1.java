package onboarding;

import java.util.List;

class Problem1 {
    public static boolean isValidPage(List<Integer> page) {
        if (page.get(0) < 1 || page.get(0) > 400 || page.get(1) < 1 || page.get(1) > 400) { // 1~400페이지가 아닌경우
            return false;
        }
        if (page.get(0) % 2 != 1 || page.get(1) % 2 != 0) { // 왼쪽 페이지가 홀수가 아닌 경우, 오른쪽 페이지가 짝수가 아닌 경우
            return false;
        }
        if (page.get(0) + 1 != page.get(1)) { // 연속된 페이지가 아닌 경우
            return false;
        }
        return true;
    }

    public static int getScore(List<Integer> page) {
        int maxScore = 0;

        for (Integer pageNum : page) {
            int pageSum = 0; // 페이지 각 자리 숫자의 합
            int pageProduct = 1; // 페이지 각 자리 숫자의 곱

            while (pageNum > 0) {
                pageSum += pageNum % 10;
                pageProduct *= pageNum % 10;
                pageNum /= 10;

            }

            if (maxScore < Math.max(pageSum, pageProduct)) {
                maxScore = Math.max(pageSum, pageProduct);
            }
        }

        return maxScore;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        /*
         * 먼저 페이지의 유효성을 체크하고, 그 다음 승자를 계산한다.
         */
        int answer = Integer.MAX_VALUE;
        int pobiScore;
        int crongScore;

        if (isValidPage(pobi) == false || isValidPage(crong) == false) {
            return -1;
        }

        pobiScore = getScore(pobi);
        crongScore = getScore(crong);

        if (pobiScore > crongScore) {
            answer = 1;
        } else if (pobiScore < crongScore) {
            answer = 2;
        } else if (pobiScore == crongScore) {
            answer = 0;
        }

        return answer;
    }
}