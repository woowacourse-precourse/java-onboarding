package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private int addedNumbers(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    private int multipliedNumbers(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }

    private int judgmentException(int firstNumber, int secondNumber) {
        if (secondNumber - firstNumber > 1) {
            return -1;
        }
        return 0;
    }

    private int comparingNumbers(int addedNum, int multipliedNum) {
        return addedNum > multipliedNum ? addedNum : multipliedNum;
    }

    private int selectingWinner(int pobiNumber, int crongNumber) {
        if (pobiNumber > crongNumber) {
            return 1;
        } else if (pobiNumber < crongNumber) {
            return 2;
        }
        return 0;
    }

}