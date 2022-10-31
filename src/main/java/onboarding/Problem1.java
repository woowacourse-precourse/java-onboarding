package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {

    private static final int startNum = 1;
    private static final int lastNum = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        // 둘 다 1을 return해야 예외사항 X
        if (!isPageValid(pobi) || !isPageValid(crong))
            return -1;

        // pobi와 crong 각각의 최고 점수를 계산한다.
        int pobiScore = Math.max( calculateScore(pobi.get(0)), calculateScore(pobi.get(1)) );
        int crongScore = Math.max( calculateScore(crong.get(0)), calculateScore(crong.get(1)) );

        // pobi 점수가 더 크다면 1, 작다면 2, 같다면 0을 반환
        if (pobiScore > crongScore)
            return 1;

        if (pobiScore < crongScore)
            return 2;

        return 0;
    }

    /**
     * 기능 1.1
     * input 페이지에 대한 Validation
     */
    public static boolean isPageValid(List<Integer> pages) {
        // lPage : 왼쪽 페이지 번호, rPage : 오른쪽 페이지 번호
        int lPage = pages.get(0);
        int rPage = pages.get(1);

        // lPage와 rPage가 연속된 페이지
        if ((rPage - lPage) != 1)
            return false;

        // rPage는 startNum초과 lastNum이하
        if (!(rPage > startNum && rPage <= lastNum))
            return false;

        // rPage는 짝수, lPage는 홀수
        if (rPage % 2 != 0)
            return false;

        return true;
    }

    /**
     * 기능 1.2
     * 페이지로 점수 계산
     */
    public static int calculateScore(Integer page) {

        int sumScore = 0;
        int sqrSumScore= 1;

        List<Character> chars = getChars(page);

        for (Character aChar : chars) {
            sumScore += Integer.parseInt(aChar.toString());
            sqrSumScore *= Integer.parseInt(aChar.toString());
        }


        return Math.max(sumScore, sqrSumScore);
    }

    private static List<Character> getChars(Integer page) {

        // 페이지의 각 자리의 숫자를 List에 저장
        return new CharSpliter<Integer>().getChars(page);
    }
}