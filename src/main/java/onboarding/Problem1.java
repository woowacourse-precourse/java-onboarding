package onboarding;

import java.util.List;


/*
* 기능 목록
* 1. 유효성 검증
* 2. 펼친 페이지의 최종 점수 계산
* 3. 페이지 번호 게임의 결과 도출
* */
class Problem1 {

    // 유효성 검증
    public static boolean checkException(int leftPage, int rightPage) {
        // 시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.
        if (leftPage == 1) return true;
        if (rightPage == 400) return true;
        // 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수
        if (leftPage % 2 == 0) return true;
        if (rightPage % 2 == 1) return true;
        // 두 페이지간 숫자 차이가 1이어야 함
        if (leftPage + 1 != rightPage) return true;

        return false;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}