package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            validate(pobi);
            validate(crong);
        } catch (IllegalArgumentException ex) {
            return -1;
        }

        int pobi_score = getScore(pobi);
        int crong_score = getScore(crong);

        return compareScore(pobi_score, crong_score);
    }

    private static int getScore(List<Integer> pages) {

        int left_score = Math.max(getSum(pages.get(0)), getMul(pages.get(0)));
        int right_score = Math.max(getSum(pages.get(1)), getMul(pages.get(1)));

        return Math.max(left_score, right_score);
    }

    private static int getSum(int page) {
        int result = 0;
        while(page > 0) {
            result += (page % 10);
            page /= 10;
        }

        return result;
    }

    private static int getMul(int page) {
        int result = 1;
        while(page > 0) {
            result *= (page % 10);
            page /= 10;
        }

        return result;
    }

    private static int compareScore(int pobi_score, int crong_score) {
        if (pobi_score < crong_score) {
            return 2;
        } else if (pobi_score > crong_score) {
            return 1;
        } else {
            return 0;
        }
    }

    private static void validate(List<Integer> pages) {
        if (pages.size() != 2) {
            throw new IllegalArgumentException("페이지는 총 2쪽이어야 합니다. 현재 페이지 수 : " + pages.size());
        }

        if (pages.get(0) % 2 != 1) {
            throw new IllegalArgumentException("왼쪽 페이지가 홀수가 아닙니다. 왼쪽 페이지 : " + pages.get(0));
        }

        if (pages.get(1) % 2 != 0) {
            throw new IllegalArgumentException("오른쪽 페이지가 짝수가 아닙니다. 오른쪽 페이지 : " + pages.get(1));
        }

        if (pages.get(1) <= pages.get(0) || pages.get(1) - pages.get(0) != 1) {
            throw new IllegalArgumentException("페이지가 잘못되었습니다.");
        }

        for (Integer page : pages) {
            if (page < 1 || page > 400) {
                throw new IllegalArgumentException("페이지의 범위가 잘못되었습니다. 올바른 범위 : 1 ~ 400, 현재 페이지 : " + page);
            }
        }
    }
}