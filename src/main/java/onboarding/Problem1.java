package onboarding;

import java.util.List;
import java.util.Objects;

import static java.lang.Math.max;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (isNotValidate(pobi) || isNotValidate(crong)) {
            return GameStatus.EXCEPTION.value;
        }

        int pobiScore = calculateScore(pobi);
        int crongScore = calculateScore(crong);

        if (pobiScore > crongScore) {
            return GameStatus.WIN_POBI.value;
        } else if (pobiScore < crongScore) {
            return GameStatus.WIN_CRONG.value;
        } else {
            return GameStatus.DRAW_GAME.value;
        }
    }

    private static boolean isNotValidate(List<Integer> player) {

        // 예외 처리
        // 1. List 길이가 2 이 아니면 예외
        System.out.println(player.isEmpty());
        if (player.size() != 2) {
            return true;
        }

        // 2. null 이 있다면 예외
        if (player.stream().anyMatch(Objects::isNull)) {
            return true;
        }

        int left = player.get(0), right = player.get(1);

        // 3. left 가 2 ~ 398 사이의 값이 아니거나, 짝수면 예외
        if (left % 2 == 0 || !(1 < left && left < 399)) {
            return true;
        }

        // 4. right 가 3 ~ 399 사이의 값이 아니거나, 홀수면 예외
        if (right % 2 == 1 || !(2 < right && right < 400)) {
            return true;
        }

        // 5. right - left != 1 이면 예외
        return right - left != 1;
    }

    private static int calculateScore(List<Integer> player) {

        int left = player.get(0), right = player.get(1);

        int leftScore = max(sumDigit(left), multiplyDigit(left));
        int rightScore = max(sumDigit(right), multiplyDigit(right));

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

    private enum GameStatus {

        WIN_POBI(1), WIN_CRONG(2), DRAW_GAME(0), EXCEPTION(-1);

        private final int value;

        GameStatus(int value) {
            this.value = value;
        }
    }
}