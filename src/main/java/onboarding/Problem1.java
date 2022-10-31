package onboarding;

import java.util.List;

class Problem1 {
    private static final int LEFT = 0;
    private static final int RIGHT= 1;
    private static final int TIE = 0;
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int EXCEPTION = -1;
    private static final int PAGE_SIZE = 2;
    private static final int FIRST_LEFT_PAGE = 1;
    private static final int LAST_LEFT_PAGE = 399;

    private static boolean isValidRange(int number) {
        if (number < 1 || number > 400) {
            return false;
        }
        return true;
    }
    private static boolean isOdd(int number) {
        return number % 2 == 1;
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    private static boolean isValidPageNumber(List<Integer> pages) {
        int left = pages.get(LEFT);
        int right = pages.get(RIGHT);

        // list의 길이가 2가 아닌 경우
        if (pages.size() != PAGE_SIZE) {
            return false;
        }
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
        if (left == FIRST_LEFT_PAGE || left == LAST_LEFT_PAGE) {
            return false;
        }
        return true;
    }

    private static int getBiggestValue(int page) {
        int sum = 0;
        int multiply = 1;

        while (page != 0) {
            int number = page % 10;
            sum += number;
            multiply *= number;
            page /= 10;
        }
        return Math.max(sum, multiply);
    }

    private static int getScore(List<Integer> pages) {
        int score = -1;

        for (Integer page : pages) {
            int biggestValue = getBiggestValue(page);
            if (score < biggestValue) {
                score = biggestValue;
            }
        }
        return score;
    }

    private static int getWinner(List<Integer> pobi, List<Integer> crong) {
        int pobiScore = getScore(pobi);
        int crongScore = getScore(crong);

        if (pobiScore > crongScore) {
            return POBI_WIN;
        } else if (pobiScore < crongScore) {
            return CRONG_WIN;
        } else {
            return TIE;
        }
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;

        // 예외 처리
        if (!isValidPageNumber(pobi) || !isValidPageNumber(crong)) {
            return EXCEPTION;
        }
        // 승자 구하기(solve)
        answer = getWinner(pobi, crong);
        return answer;
    }
}
