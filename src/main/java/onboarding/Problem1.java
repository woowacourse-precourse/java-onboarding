package onboarding;

import java.util.List;

class Problem1 {
    private static int FIRST_PAGE = 1;
    private static int LAST_PAGE = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(!isValidPage(pobi.get(0), pobi.get(1), crong.get(0), crong.get(1))) {
            answer = -1;
        }

        else {
            int scoreOfPobi = Math.max(getPageScore(pobi.get(0)), getPageScore(pobi.get(1)));
            int scoreOfCrong = Math.max(getPageScore(crong.get(0)), getPageScore(crong.get(1)));

            answer = getComparisonResult(scoreOfPobi, scoreOfCrong);
        }

        return answer;
    }

    public static boolean isValidPage(int leftPageOfPobi, int rightPageOfPobi, int leftPageOfCrong, int rightPageOfCrong) {
        // 시작, 마지막 페이지가 아닌 범위의 페이지인지 체크
        if(leftPageOfPobi <= FIRST_PAGE || leftPageOfPobi >= LAST_PAGE - 1
                || rightPageOfPobi <= FIRST_PAGE + 1 || rightPageOfPobi >= LAST_PAGE
                || leftPageOfCrong <= FIRST_PAGE || leftPageOfCrong >= LAST_PAGE - 1
                || rightPageOfCrong <= FIRST_PAGE + 1 || rightPageOfCrong >= LAST_PAGE) {
                return false;
        }

        // 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수인지 체크
        if(leftPageOfPobi % 2 == 0 || leftPageOfCrong % 2 == 0
                || rightPageOfCrong % 2 == 1 || rightPageOfPobi % 2 == 1) {
            return false;
        }

        // 연속된 페이지인지 체크
        if(rightPageOfPobi - leftPageOfPobi > 1 || rightPageOfCrong - leftPageOfCrong > 1) {
            return false;
        }

        return true;
    }

    // 계산한 점수를 비교하여 승부 결과(0, 1, 2)를 리턴
    public static int getComparisonResult(int p, int c) {
        if(p < c) {
            return 2;
        }
        else if(p > c) {
            return 1;
        }
        return 0;
    }

    // 페이지 숫자를 계산한 값 중 가장 큰 점수를 반환
    public static int getPageScore(int pageNumber) {
        int addSum = 0, mulSum = 1;

        while(pageNumber != 0) {
            addSum += pageNumber % 10;
            mulSum *= pageNumber % 10;
            pageNumber /= 10;
        }

        return  Math.max(addSum, mulSum);
    }
}