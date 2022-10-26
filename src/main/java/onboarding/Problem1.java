package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        try {
            validatePages(pobi);
            validatePages(crong);
        } catch (IllegalArgumentException e) {
            return -1;
        }
        return answer;
    }

    private static void validatePages(List<Integer> pages) {
        if (pages.size() != 2) {
            throw new IllegalArgumentException("책 페이지는 두 쪽이 입력되어야 합니다.");
        }

        int leftPage = pages.get(0);
        int rightPage = pages.get(1);
        if (leftPage < 1 || leftPage > 400 || leftPage % 2 == 0 || rightPage < 1 || rightPage > 400 || rightPage % 2 == 1) {
            throw new IllegalArgumentException("올바른 페이지 번호가 아닙니다.");
        }
        if (rightPage - leftPage != 1) {
            throw new IllegalArgumentException("연속된 페이지 번호를 입력해주세요.");
        }
    }
}
