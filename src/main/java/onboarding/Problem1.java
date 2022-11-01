package onboarding;

import java.util.ArrayList;
import java.util.List;


class Problem1 {
    private static final int LEFT = 0;
    private static final int RIGHT= 1;
    private static final int TIE = 0;
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;

    private static boolean isValidRange(int number) {
        if (number < 1 || number > 400) {
            return false;
        }
        return true;
    }
    private static boolean check_left(int number) {
        return number % 2 == 1;
    }

    private static boolean check_right(int number) {
        return number % 2 == 0;
    }

    private static boolean check_PageNumber(List<Integer> pages) {
        int left = pages.get(LEFT);
        int right = pages.get(RIGHT);

        if (pages.size() != 2) {
            return false;
        }

        if (!isValidRange(left) || !isValidRange(right)) {
            return false;
        }
        // 왼쪽이 짝수거나 오른쪽이 홀수인 경우
        if (!check_left(left) || !check_right(right)) {
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

    private static int max_value(int page) {
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

        for (int i = 0; i < pages.size(); i++) {
            int biggestValue = max_value(pages.get(i));
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
        int answer = 0;

        if (!check_PageNumber(pobi) || !check_PageNumber(crong))
            return -1;
        answer = getWinner(pobi, crong);
        return answer;
    }
}