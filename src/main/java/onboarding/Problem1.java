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

    private static void validatePages(List<Integer> gamer) {
        if (gamer.size() != 2) {
            throw new IllegalArgumentException("올바른 페이지 개수는 2개입니다.");
        }

        if (!gamer.stream().allMatch(Problem1::isAvailPageRange)) {
            throw new IllegalArgumentException("올바른 범위의 페이지를 입력해주세요.");
        }

        int leftPage = gamer.get(0);
        int rightPage = gamer.get(1);

        if (isEven(leftPage) || !isEven(rightPage)) {
            throw new IllegalArgumentException("왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수여야 합니다.");
        }

        if (rightPage != leftPage + 1) {
            throw new IllegalArgumentException("연속된 페이지를 입력해주세요.");
        }
    }

    private static int calcSinglePageScore(int page) {
        int addSum = 0;
        int multSum = 1;

        for (byte b : String.valueOf(page).getBytes()) {
            int val = Character.getNumericValue(b);
            addSum += val;
            multSum *= val;
        }

        return Math.max(addSum, multSum);
    }

    private static boolean isAvailPageRange(int page) {
        return page >= 0 && page <= 400;
    }

    private static boolean isEven(int val) {
        return val % 2 == 0;
    }
}
