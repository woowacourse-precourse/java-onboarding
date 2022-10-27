package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    private static int startNum = 1;
    private static int lastNum = 400;
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;

        // 둘 다 1을 return해야 예외사항 X
        if (pageValidation(pobi) + pageValidation(crong) != 2)
            return -1;

        // pobi와 crong 각각의 최고 점수를 계산한다.
        int pobiScore = Math.max(calculateScore(pobi.get(0)), calculateScore(pobi.get(1)));
        int crongScore = Math.max(calculateScore(crong.get(0)), calculateScore(crong.get(1)));

        // pobi 점수가 더 크다면 1, 작다면 2, 같다면 0을 반환
        if (pobiScore > crongScore)
            answer = 1;
        else if (pobiScore == crongScore)
            answer = 0;
        else
            answer = 2;

        return answer;
    }

    /**
     * 기능 1.1
     * input 페이지에 대한 Validation
     */
    public static int pageValidation(List<Integer> pages) {
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

    /**
     * 기능 1.2
     * 페이지로 점수 계산
     */
    public static int calculateScore(Integer page) {

        int sumScore = 0;
        int sqrSumScore= 1;

        // 페이지의 각 자리의 숫자를 ArrayList에 저장
        List<Integer> pageElements = new ArrayList<>();
        while (page > 0) {
            pageElements.add(page % 10);
            page /= 10;
        }

        for (int i = 0; i < pageElements.size(); i++) {
            sumScore += pageElements.get(i);
            sqrSumScore *= pageElements.get(i);
        }

        return Math.max(sumScore, sqrSumScore);
    }
}