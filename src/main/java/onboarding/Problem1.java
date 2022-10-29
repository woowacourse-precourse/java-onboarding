package onboarding;

import java.util.List;

/**
 * 기능 정의
 * 1. 페이지로 Score얻기
 * 2. Score 비교
 * 3. 리스트/배열 메소드 오버로딩(isErrorPages, solution)
 * 4. 예외처리 구현
 *  4-1 왼쪽 페이지가 홀수? 오른쪽 페이지가 짝수?
 *  4-2 왼쪽 페이지와 오른쪽 페이지가 범위 내의 페이지인가?
 *  4-3 왼쪽 페이지와 오른쪽 페이지가 연속된 페이지인가?
 */
class Problem1 {

    private static int getMaxScore(int page){
        int result;

        int add = 0;
        int mul = 1;

        while (page != 0){
            add += page % 10;
            mul *= page % 10;
            page /= 10;
        }

        result = Math.max(add, mul);

        return result;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int pobiScore = Math.max(getMaxScore((pobi.get(0))), getMaxScore(pobi.get(1)));
        int crongScore = Math.max(getMaxScore((crong.get(0))), getMaxScore(crong.get(1)));

        if (pobiScore > crongScore){
            return 1;
        } else if (pobiScore < crongScore) {
            return 2;
        } else if (pobiScore == crongScore) {
            return 0;
        }

        return -1;
    }
}