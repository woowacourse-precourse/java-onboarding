package onboarding;

import onboarding.enums.GameStatus;

import java.util.List;
import java.util.Objects;

import static java.lang.Math.max;

class Problem1 {

    public static final int INDEX_LEFT_PAGE = 0;
    public static final int INDEX_RIGHT_PAGE = 1;

    public static final int MIN_LEFT_PAGE = 1;
    public static final int MAX_LEFT_PAGE = 399;

    public static final int MIN_RIGHT_PAGE = 2;
    public static final int MAX_RIGHT_PAGE = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (isNotValidate(pobi) || isNotValidate(crong)) {
            return GameStatus.EXCEPTION.getValue();
        }

        int pobiScore = calculateScore(pobi);
        int crongScore = calculateScore(crong);

        return GameStatus.getResultOfGame(pobiScore, crongScore)
                .getValue();
    }

    private static int calculateScore(List<Integer> player) {

        int leftPage = player.get(INDEX_LEFT_PAGE);
        int rightPage = player.get(INDEX_RIGHT_PAGE);

        int leftScore = max(sumDigit(leftPage), multiplyDigit(leftPage));
        int rightScore = max(sumDigit(rightPage), multiplyDigit(rightPage));

        return max(leftScore, rightScore);
    }

    private static int sumDigit(int num) {

        int result = 0;
        while (num > 0) {
            result += num % 10;
            num /= 10;
        }
        return result;
    }

    private static int multiplyDigit(int num) {

        int result = 1;
        while (num > 0) {
            result *= num % 10;
            num /= 10;
        }
        return result;
    }

    private static boolean isNotValidate(List<Integer> player) {

        // 1. List 길이가 2 이 아니면 예외
        if (player.size() != 2) {
            return true;
        }

        // 2. null 이 있다면 예외
        if (player.stream().anyMatch(Objects::isNull)) {
            return true;
        }


        int leftPage = player.get(INDEX_LEFT_PAGE);
        int rightPage = player.get(INDEX_RIGHT_PAGE);

        // 3. leftPage 가 2 ~ 398 사이의 값이 아니거나, 짝수면 예외
        if (leftPage % 2 == 0 || !(MIN_LEFT_PAGE < leftPage && leftPage < MAX_LEFT_PAGE)) {
            return true;
        }

        // 4. rightPage 가 3 ~ 399 사이의 값이 아니거나, 홀수면 예외
        if (rightPage % 2 == 1 || !(MIN_RIGHT_PAGE < rightPage && rightPage < MAX_RIGHT_PAGE)) {
            return true;
        }


        // 5. rightPage - leftPage != 1 이면 예외
        return rightPage - leftPage != 1;
    }
}