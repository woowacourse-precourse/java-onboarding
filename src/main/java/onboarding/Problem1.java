package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiScore = getPlayerScore(pobi);
        int crongScore = getPlayerScore(crong);
        answer = getWinnerNum(pobiScore, crongScore);
        return answer;
    }

    public static int sumPageEachDigitNum(Integer pageNum) {
        int eachDigitNumSum = 0;
        while(pageNum != 0) {
            eachDigitNumSum += pageNum % 10;
            pageNum /= 10;
        }
        return eachDigitNumSum;
    }

    public static int multiplyPageEachDigitNum(Integer pageNum) {
        int eachDigitNumMultiplication = 1;
        while(pageNum != 0) {
            eachDigitNumMultiplication *= pageNum % 10;
            pageNum /= 10;
        }
        return eachDigitNumMultiplication;
    }

    public static int getPlayerScore(List<Integer> player) {
        Integer leftPageNum = player.get(0);
        Integer rightPageNum = player.get(1);
        int leftPageLargerNum = Math.max(sumPageEachDigitNum(leftPageNum), multiplyPageEachDigitNum(leftPageNum));
        int rightPageLargerNum = Math.max(sumPageEachDigitNum(rightPageNum), multiplyPageEachDigitNum(rightPageNum));
        return Math.max(leftPageLargerNum, rightPageLargerNum);
    }

    public static int getWinnerNum(int player1Score, int player2Score) {
        int winnerNum = 0;
        if(player1Score > player2Score) winnerNum = 1;
        if(player1Score < player2Score) winnerNum = 2;
        if(player1Score == player2Score) winnerNum = 0;
        return winnerNum;
    }

    public static boolean validatePageNumOddOrEven(List<Integer> player) {
        Integer leftPageNum = player.get(0);
        Integer rightPageNum = player.get(1);
        return ((leftPageNum % 2 != 0) && (rightPageNum % 2 == 0));
    }

    public static boolean validatePageRange(List<Integer> player) {
        Integer leftPageNum = player.get(0);
        Integer rightPageNum = player.get(1);
        return ((leftPageNum > 1) && (rightPageNum < 400));
    }
}