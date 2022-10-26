/*
[기능 목록]
1. 왼쪽, 오른쪽 페이지 번호의 유효성 체크
    - 페이지 범위 체크
    - 페이지 번호 차이 체크
    - 왼쪽 페이지 홀수인지 체크

2. 점수 계산
    - 각 페이지의 점수 계산
        - 페이지 번호의 각 자리 합
        - 페이지 번호의 각 자리 곱

3. 게임 결과 계산
 */


package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static boolean checkValidatePairOfPage (List<Integer> pages) {
        // 1. 페이지 유효 범위는 3이상 398 이하
        if (!checkRangeOfPages(pages)) {
            return false;
        }

        // 2. 두 페이지간 차이가 1
        if (pages.get(1) - pages.get(0) != 1) {
            return false;
        }

        // 3. 앞쪽 페이지는 홀수, 뒤쪽 페이지는 짝수
        if (!isOdd(pages.get(0))) {
            return false;
        }

        return true;
    }

    private static boolean checkRangeOfPages (List<Integer> pages) {
        for (int page : pages) {
            if (!checkRange(page)) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkRange(int pageNum) {
        return pageNum >= 3 && pageNum <= 398;
    }

    private static boolean isOdd (int num) {
        return num % 2 == 1;
    }
}