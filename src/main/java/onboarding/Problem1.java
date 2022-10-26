package onboarding;

import java.util.List;

class Problem1 {
    private static final int LEFT = 0;
    private static final int RIGHT= 1;

    public static boolean isValidRange(int number) {
        if (number < 1 || number > 400) {
            return false;
        }
        return true;
    }
    public static boolean isOdd(int number) {
        return number % 2 == 1;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static boolean isValidPageNumber(List<Integer> pages) {
        int left = pages.get(LEFT);
        int right = pages.get(RIGHT);

        // page의 범위가 벗어난 경우
        if (!isValidRange(left) || !isValidRange(right)) {
            return false;
        }
        // 왼쪽이 짝수거나 오른쪽이 홀수인 경우
        if (!isOdd(left) || !isEven(right)) {
            return false;
        }
        // 연속적인 페이지가 아닌 경우
        if (left + 1 != right) {
            return false;
        }
        // 시작면이나 마지막면이 나온 경우
        if (left == 1 || left == 399) {
            return false;
        }
        return true;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;

        // 예외 처리
        if (!isValidPageNumber(pobi) || !isValidPageNumber(crong)) {
            return -1;
        }
        return answer;
    }
}

