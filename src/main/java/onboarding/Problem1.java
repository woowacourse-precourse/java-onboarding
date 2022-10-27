package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        return answer;
    }

    /**
     * 1.1
     * input 페이지에 대한 Validation
     */
    public static int pageValidation(List<Integer> pages, int startNum, int lastNum) {
        // lPage : 왼쪽 페이지 번호, rPage : 오른쪽 페이지 번호
        int lPage = pages.get(0);
        int rPage = pages.get(1);

        // lPage와 rPage가 연속된 페이지
        if ((rPage - lPage) != 1)
            return -1;

        // rPage는 startNum초과 lastNum이하
        if (!(rPage > startNum && rPage <= lastNum))
            return -1;

        // rPage는 짝수, lPage는 홀수
        if (rPage % 2 != 0)
            return -1;

        return 1;
    }
}