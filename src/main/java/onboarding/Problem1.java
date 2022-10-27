package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // 둘 중 하나라도 정상적인 입력이 아니면 -1 반환
        if (!isValidPages(pobi) || !isValidPages(crong)) {
            return -1;
        }

        int pobiMax = Math.max(getMaxAfterCalc(pobi.get(0)),getMaxAfterCalc(pobi.get(1)));
        int crongMax = Math.max(getMaxAfterCalc(crong.get(0)),getMaxAfterCalc(crong.get(1)));

        if (pobiMax > crongMax) {
            answer = 1;
        }else if (pobiMax == crongMax) {
            answer = 0;
        }else {
            answer = -1;
        }


        return answer;
    }

    /**
     * 페이지 번호의 각자리 숫자를 모두 더한 수, 모두 곱한 수 중 큰값을 반환하는 함수
     * 제한사항을 만족할 때 왼쪽 페이지 번호를 받는다.
     * @param 페이지 번호
     * @return 두 값 중 큰 값
     */
    private static int getMaxAfterCalc(int page) {
        int add = 0, multiply = 1;

        while (page > 0) {
            add += page % 10;
            multiply *= page % 10;

            page /= 10;
        }

        if (add < multiply)
            return multiply;
        else
            return add;
    }

    private static boolean isValidPages(List<Integer> pages) {
        // 예외1. 페이지가 잘못입력됨 (1 ~ 400가 아닐경우)
        for(int i=0; i<2; i++) {
            if (pages.get(i) < 1 || 400 < pages.get(i))  return false;
        }

        // 예외2. 정상적인 값이 아님 (왼쪽페이지+1 != 오른쪽페이지)
        if (pages.get(0)+1 != pages.get(1)) return false;

        // 예외3. 페이지 번호의 개수가 2장이 아님
        if (pages.size() != 2) return false;

        return true;
    }

}