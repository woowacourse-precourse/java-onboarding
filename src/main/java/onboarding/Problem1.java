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

    // 한 페이지의 덧셈 결과
    public static int getPlusResult(int number) {
        int ans = 0;
        while (number > 0) {
            ans += number % 10;
            number /= 10;
        }
        return ans;
    }
    // 한 페이지의 곱셈 결과
    public static int getMulResult(int number) {
        int ans = 1;
        while (number > 0) {
            ans *= number % 10;
            number /= 10;
        }
        return ans;
    }
    // 한 페이지의 계산 결과 최댓값
    public static int getPageMaxResult(int number) {
        return Math.max(getPlusResult(number), getMulResult(number));
    }
    // 양 페이지의 계산 결과 최댓값
    public static int getMaxResult(int leftPage, int rightPage) {
        return Math.max(getPageMaxResult(leftPage), getPageMaxResult(rightPage));
    }

    // 페이지 번호 게임의 결과 도출
    public static int getAnswer(Integer pobiLeftPage, Integer pobiRightPage, Integer crongLeftPage, Integer crongRightPage) {
        int pobiResult = getMaxResult(pobiLeftPage, pobiRightPage);
        int crongResult = getMaxResult(crongLeftPage, crongRightPage);

        if (pobiResult > crongResult) {
            return 1;
        } else if (pobiResult < crongResult) {
            return 2;
        } else {
            return 0;
        }
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Integer pobiLeftPage = pobi.get(0);
        Integer pobiRightPage = pobi.get(1);
        Integer crongLeftPage = crong.get(0);
        Integer crongRightPage = crong.get(1);

        if (checkException(pobiLeftPage, pobiRightPage) || checkException(crongLeftPage, crongRightPage)) {
            return -1;
        }

        return getAnswer(pobiLeftPage, pobiRightPage, crongLeftPage, crongRightPage);
    }
}