package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiScore = getScore(pobi.get(0), pobi.get(1));
        int crongScore = getScore(crong.get(0), crong.get(1));
        return compareScores(pobiScore, crongScore);
    }
    
    private static boolean isValid(Integer number1, Integer number2) {
        if (number1 == null || number2 == null) {
            return false;
        }
        if (number1%2 == 0 || number2%2 != 0) {
            return false;
        }
        if ((number2 - number1) != 1) {
            return false;
        }
        if (number1 < 1 || number2 > 400) {
            return false;
        }
        return true;
    }

    private static int getSumOfDigits(int number) {
        int result = 0;
        while (number != 0) {
            result += number % 10;
            number /= 10;
        }
        return result;
    }

    private static int getMultipliedOfDigits(int number) {
        int result = 1;
        while (number != 0) {
            result *= number % 10;
            number /= 10;
        }
        return result;
    }

    private static int getScore(int leftPage, int rightPage) {
        if (!isValid(leftPage, rightPage)) {
            return -1;
        }
        int leftPageValue = Math.max(getSumOfDigits(leftPage), getMultipliedOfDigits(leftPage));
        int rightPageValue = Math.max(getSumOfDigits(rightPage), getMultipliedOfDigits(rightPage));
        return Math.max(leftPageValue, rightPageValue);
    }
    
    private static int compareScores(int score1, int score2) {
        int answer = Integer.MAX_VALUE;
        if (score1 < 0 || score2 < 0) {
            return -1;
        }
        if (score1 == score2) {
            answer =  0;
        }
        if (score1 > score2) {
            answer =  1;
        }
        if (score1 < score2) {
            answer =  2;
        }
        return answer;
    }
}