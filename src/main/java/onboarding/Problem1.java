package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        try {
            validate(pobi);
            validate(crong);
        } catch (IllegalStateException ex) {
            return -1;
        }

        return answer;
    }

    private static void validate(List<Integer> pages) {
        if (pages.size() != 2) {
            throw new IllegalStateException("페이지는 총 2쪽이어야 합니다. 현재 페이지 수 : " + pages.size());
        }

        if (pages.get(0) % 2 != 1) {
            throw new IllegalStateException("왼쪽 페이지가 홀수가 아닙니다. 왼쪽 페이지 : " + pages.get(0));
        }

        if (pages.get(1) % 2 != 0) {
            throw new IllegalStateException("오른쪽 페이지가 짝수가 아닙니다. 오른쪽 페이지 : " + pages.get(1));
        }

        if (pages.get(1) <= pages.get(0) || pages.get(1) - pages.get(0) != 1) {
            throw new IllegalStateException("페이지가 잘못되었습니다.");
        }

        for (Integer page : pages) {
            if (page < 1 || page > 400) {
                throw new IllegalStateException("페이지의 범위가 잘못되었습니다. 올바른 범위 : 1 ~ 400, 현재 페이지 : " + page);
            }
        }
    }
}