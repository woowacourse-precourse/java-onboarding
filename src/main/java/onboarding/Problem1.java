package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isException(pobi) || isException(crong)) {
            return -1;
        }

        int pobiScore = getScore(pobi);
        int crongScore = getScore(crong);

        if (pobiScore > crongScore) {
            return 1;
        }

        if (pobiScore < crongScore) {
            return 2;
        }

        if (pobiScore == crongScore) {
            return 0;
        }

        return -1;
    }

    // 예외 처리
    private static boolean isException(List<Integer> person) {
        Integer left = person.get(0);
        Integer right = person.get(1);

        return (right - left) != 1 || (right % 2) != 0 || (left % 2) != 1;
    }

    // 점수 구하기
    private static int getScore(List<Integer> person) {
        Integer left = person.get(0);
        Integer right = person.get(1);

        return Math.max(getMaxScore(left), getMaxScore(right));
    }

    // 페이지 자릿수 합 구하기
    private static int getSum(Integer page) {
        String str = page.toString();
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            result += str.charAt(i) - '0';
        }
        return result;
    }

    // 페이지 자릿수 곱 구하기
    private static int getMultiple(Integer page) {
        String str = page.toString();
        int result = 1;
        for (int i = 0; i < str.length(); i++) {
            result *= str.charAt(i) - '0';
        }
        return result;
    }

    // 곱과 합 중에 최댓값 구하기
    private static int getMaxScore(Integer page) {
        return Math.max(getSum(page), getMultiple(page));
    }
}