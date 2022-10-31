package onboarding;

import java.util.*;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // 페이지 번호가 유효한 범위인지 체크
        for (int i = 0; i < 2; i++) {
            if (pageInvalidBoundCheck(pobi.get(i)) || pageInvalidBoundCheck(crong.get(i))) {
                return -1;
            }
        }

        // 페이지 정보가 올바른지 확인
        if (pageInvalidLogicCheck(pobi) || pageInvalidLogicCheck(crong)) {
            return -1;
        }

        // 페이지 번호 게임 시작
        int pobiMax = 0, crongMax = 0;
        pobiMax = getResultOfGame(pobi);
        crongMax = getResultOfGame(crong);
        if (crongMax > pobiMax) {
            answer = 2;
        } else if (crongMax < pobiMax) {
            answer = 1;
        } else if (crongMax == pobiMax) {
            answer = 0;
        }

        return answer;
    }

    /**
     * 페이지 번호가 비정상적인 숫자인지 확인하는 함수
     *
     * @param page 포비 또는 크롱이 펼친 페이지
     * @return [3, 398]이면 {@Code false}, 그렇지 않으면 {@Code true}
     */
    public static boolean pageInvalidBoundCheck(int page) {
        if (3 <= page && page <= 398) {
            return false;
        }
        return true;
    }

    /**
     * 두 페이지 번호가 약속한 규칙을 어겼는지 확인하는 함수
     *
     * @param page 포비 또는 크롱이 책을 펼쳤을 때 나온 페이지 정보
     * @return 페이지 정보가 2개이고,
     * {@Code 왼쪽페이지 + 1 = 오른쪽페이지}이고,
     * {@Code 왼쪽페이지 = 홀수}이면 {@Code false}
     * 셋 중 하나라도 어기면 {@Code true}
     */
    public static boolean pageInvalidLogicCheck(List<Integer> page) {
        if (page.size() == 2) {
            int leftPage = page.get(0);
            int rightPage = page.get(1);
            if (leftPage + 1 == rightPage && leftPage % 2 == 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param page 책을 펼쳤을 때 나오는 페이지 정보
     * @return  주어진 페이지 정보로 게임을 했을 때 나오는 결과값
     */
    public static int getResultOfGame(List<Integer> page) {
        int maxValue = Integer.MIN_VALUE; // 페이지 게임에 대한 결과
        for (int i = 0; i < 2; i++) {
            maxValue = Math.max(maxValue, calculate(page.get(i)));
        }
        return maxValue;
    }

    /**
     * @param pageNumber 페이지 번호
     * @return {@Code Max(페이지 번호의 각 자리수에 대해 덧셈한 값, 또는 곱셈한 값)
     */
    private static int calculate(int pageNumber) {
        List<Integer> digits = new LinkedList<>();
        int share = 0;
        while (pageNumber > 0) {
            share = pageNumber % 10;
            digits.add(share);
            pageNumber /= 10;
        }
        int sum = digits.stream().reduce(Integer::sum).get();
        int mul = digits.stream().reduce((x, y) -> x * y).get();
        return Math.max(sum, mul);
    }
}