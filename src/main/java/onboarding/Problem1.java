package onboarding;

import java.util.List;

import static onboarding.Problem1.isValidPage;

class Problem1 {
    private static int FIRST_PAGE = 1;
    private static int LAST_PAGE = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(isValidPage(pobi, crong) == false) {
            answer = -1;
        }

        else {
            int scoreOfPobi = getBigger(getPageScore(pobi.get(0)), getPageScore(pobi.get(1)));
            int scoreOfCrong = getBigger(getPageScore(crong.get(0)), getPageScore(crong.get(1)));

            answer = getComparisonResult(scoreOfPobi, scoreOfCrong);
        }

        return answer;
    }

    // 페이지 번호가 적절한 값인지 체크
    public static boolean isValidPage(List<Integer> pobi, List<Integer> crong) {

        return false;
    }

    // 계산한 점수를 비교하여 승부 결과(0, 1, 2)를 리턴
    public static int getComparisonResult(int scoreOfPobi, int scoreOfCrong) {

        return -1;
    }

    public static int getBigger(int a, int b) {
        return (a > b) ? a : b;
    }

    // 페이지 숫자를 계산한 값 중 가장 큰 점수를 반환
    public static int getPageScore(int pageNumber) {
        int score = 0;

        return  score;
    }
}