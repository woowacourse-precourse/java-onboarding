package onboarding;

import java.util.List;

class Problem1 {

    private static final int EXCEPTION_RETURN_VALUE = -1;
    private static final int VARIABLE_INIT_VALUE = 0;
    private static final int MULTIPLICATION_VARIABLE_INIT_VALUE = 1;
    private static final int LEFT_PAGE_NUM_INDEX = 0;
    private static final int RIGHT_PAGE_NUM_INDEX = 1;
    private static final int PLAYER1_WINNING_NUMBER = 1;
    private static final int PLAYER2_WINNING_NUMBER = 2;
    private static final int DRAW_NUMBER = 0;
    private static final int MIN_PAGE_NUMBER = 1;
    private static final int MAX_PAGE_NUMBER = 400;
    private static final int CONTINUITY_JUDGEMENT_NUMBER = 1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if(validateGame(pobi) && validateGame(crong)) {
            int player1Score = getPlayerScore(pobi);
            int player2Score = getPlayerScore(crong);
            answer = getWinnerNum(player1Score, player2Score);
        }
        if(!validateGame(pobi) || !validateGame(crong)) {
            answer = EXCEPTION_RETURN_VALUE;
        }
        return answer;
    }

    private static int sumPageEachDigitNum(Integer pageNum) {
        int eachDigitNumSum = VARIABLE_INIT_VALUE;
        while(pageNum != 0) {
            eachDigitNumSum += pageNum % 10;
            pageNum /= 10;
        }
        return eachDigitNumSum;
    }

    private static int multiplyPageEachDigitNum(Integer pageNum) {
        int eachDigitNumMultiplication = MULTIPLICATION_VARIABLE_INIT_VALUE;
        while(pageNum != 0) {
            eachDigitNumMultiplication *= pageNum % 10;
            pageNum /= 10;
        }
        return eachDigitNumMultiplication;
    }

    private static int getPlayerScore(List<Integer> player) {
        Integer leftPageNum = player.get(LEFT_PAGE_NUM_INDEX);
        Integer rightPageNum = player.get(RIGHT_PAGE_NUM_INDEX);
        int leftPageLargerNum = Math.max(sumPageEachDigitNum(leftPageNum), multiplyPageEachDigitNum(leftPageNum));
        int rightPageLargerNum = Math.max(sumPageEachDigitNum(rightPageNum), multiplyPageEachDigitNum(rightPageNum));
        return Math.max(leftPageLargerNum, rightPageLargerNum);
    }

    private static int getWinnerNum(int player1Score, int player2Score) {
        int winnerNum = VARIABLE_INIT_VALUE;
        if(player1Score > player2Score) winnerNum = PLAYER1_WINNING_NUMBER;
        if(player1Score < player2Score) winnerNum = PLAYER2_WINNING_NUMBER;
        if(player1Score == player2Score) winnerNum = DRAW_NUMBER;
        return winnerNum;
    }

    private static boolean validateGame(List<Integer> player) {
        return (validatePageNumOddOrEven(player) && validatePageRange(player) && validateContinuousPageNum(player));
    }

    private static boolean validatePageNumOddOrEven(List<Integer> player) {
        Integer leftPageNum = player.get(LEFT_PAGE_NUM_INDEX);
        Integer rightPageNum = player.get(RIGHT_PAGE_NUM_INDEX);
        return ((leftPageNum % 2 != 0) && (rightPageNum % 2 == 0));
    }

    private static boolean validatePageRange(List<Integer> player) {
        Integer leftPageNum = player.get(LEFT_PAGE_NUM_INDEX);
        Integer rightPageNum = player.get(RIGHT_PAGE_NUM_INDEX);
        return ((leftPageNum > MIN_PAGE_NUMBER) && (rightPageNum < MAX_PAGE_NUMBER));
    }

    private static boolean validateContinuousPageNum(List<Integer> player) {
        Integer leftPageNum = player.get(LEFT_PAGE_NUM_INDEX);
        Integer rightPageNum = player.get(RIGHT_PAGE_NUM_INDEX);
        return (rightPageNum - leftPageNum == CONTINUITY_JUDGEMENT_NUMBER);
    }
}