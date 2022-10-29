package onboarding;

import java.util.List;

class Problem1 {
    static int FIRST_PAGE = 1;
    static int LAST_PAGE = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static void checkPages(List<Integer> pages) throws Exception {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        if (leftPage < FIRST_PAGE || rightPage > LAST_PAGE) {
            throw new Exception("페이지 범위를 초과했습니다.");
        }
        if (leftPage + 1 != rightPage) {
            throw new Exception("연속된 숫자를 입력해야 합니다.");
        }
        if (leftPage % 2 != 1) {
            throw new Exception("왼쪽 페이지는 홀수이어야 합니다.");
        }
    }
}