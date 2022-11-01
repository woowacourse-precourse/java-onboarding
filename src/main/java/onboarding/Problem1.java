package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            // 포비와 크롱의 점수 계산
            int pobiScore = getScoreFromPages(pobi);
            int crongScore = getScoreFromPages(crong);

            // 최대 점수로 게임 시작
            Result result = startGame(pobiScore, crongScore);

            // 게임 결과 반환
            switch (result) {
                case DRAW:
                    return 0;
                case POBI_WIN:
                    return 1;
                case CRONG_WIN:
                    return 2;
            }
        } catch (GameException e) {
            return e.getValue();
        }
        return -1;
    }

    private static int getScoreFromPages(List<Integer> pages) throws GameException {
        // 입력받은 페이지 배열에서 왼쪽 페이지와 오른쪽 페이지를 따로 계산
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        // 기능 요구 사항 예외 처리
        if (!verifyPageCondition(leftPage, rightPage))
            throw new GameException();

        // 정수형 페이지 변수의 자릿수를 통해 점수를 계산하기 위해 자릿수 배열 생성
        List<Integer> leftPageDigits = getDigitsFromNumber(leftPage);
        List<Integer> rightPageDigits = getDigitsFromNumber(rightPage);

        // 자릿수 배열에서 기능 요구 사항에 맞춰 최대 점수 계산
        int maxLeftPage = getMaxScore(leftPageDigits);
        int maxRightPage = getMaxScore(rightPageDigits);

        // 최대 점수 후보 중 가장 큰 수 반환
        return Math.max(maxLeftPage, maxRightPage);
    }

    private static List<Integer> getDigitsFromNumber(int num) {
        List<Integer> digits = new ArrayList<>();
        while (num > 0) {
            digits.add(num % 10);
            num /= 10;
        }
        return digits;
    }

    private static int getMaxScore(List<Integer> numList) {
        int sumOfNums = numList.stream().reduce(0, Integer::sum);
        int multiplyOfNums = numList.stream().reduce(1, (a, b) -> a * b);

        return Math.max(sumOfNums, multiplyOfNums);
    }

    private static Result startGame(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) {
            return Result.POBI_WIN;
        } else if (crongScore > pobiScore) {
            return Result.CRONG_WIN;
        } else {
            return Result.DRAW;
        }
    }

    private static Boolean verifyPageCondition(int leftPage, int rightPage) {
        if (leftPage % 2 == 0 || rightPage % 2 == 1)
            return false;
        if (rightPage - leftPage != 1)
            return false;
        if (leftPage == 1 || rightPage == 400)
            return false;
        return true;
    }

    public enum Result {
        DRAW, POBI_WIN, CRONG_WIN
    }

    public static class GameException extends Exception {
        private static final int value = -1;

        public int getValue() {
            return value;
        }
    }
}
