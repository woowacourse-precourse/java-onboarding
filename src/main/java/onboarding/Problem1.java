package onboarding;

import java.util.List;

/**
 * Problem 01 기능 목록
 * - 올바른 입력값 확인 (크기 검사, 값 검사)
 * - 펼친 페이지에서의 최댓값 계산
 * - 포비와 크롱 중에서 승자를 결정
 */
class Problem1 {

    private boolean isAvailableInput(List<Integer> pages) {
        return isAvailableSize(pages.size()) && isAvailableValues(pages.get(0), pages.get(1));
    }

    private boolean isAvailableSize(int size) {
        return size == 2;
    }

    private boolean isAvailableValues(int left, int right) {
        return 1 <= left && left <= 399 && left + 1 == right;
    }

    private int plusEach(int page) {
        int sum = 0;
        while (page != 0) {
            sum += page % 10;
            page /= 10;
        }
        return sum;
    }

    private int multiplyEach(int page) {
        int mul = 1;
        while (page != 0) {
            mul *= page % 10;
            page /= 10;
            if (mul == 0)
                break;
        }
        return mul;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}