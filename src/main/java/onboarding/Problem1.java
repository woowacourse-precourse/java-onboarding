package onboarding;

import java.util.List;

class Problem1 {
    public static int findWinner(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) {
            return 1;
        }
        if (crongScore < pobiScore) {
            return 2;
        }
        return 0;
    }

    public static int getLeftPageScore(List<Integer> pages) {
        int score;
        score = Math.max(getSumOfDigits(pages.get(0)), getMultiplyOfDigits(pages.get(0)));

        return score;
    }

    public static int getRightPageScore(List<Integer> pages) {
        int score;
        score = Math.max(getSumOfDigits(pages.get(1)), getMultiplyOfDigits(pages.get(1)));

        return score;
    }

    public static int getMultiplyOfDigits(int number) {
        int multiply = 1;
        while(number != 0){
            multiply *= number%10;
            number /= 10;
        }

        return multiply;
    }

    public static int getSumOfDigits(int number) {
        int sum = 0;
        while(number != 0){
            sum += number%10;
            number /= 10;
        }

        return sum;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiScore;
        int crongScore;

        pobiScore = Math.max(getLeftPageScore(pobi), getRightPageScore(pobi));
        crongScore = Math.max(getLeftPageScore(crong), getRightPageScore(crong));
        answer = findWinner(pobiScore, crongScore);

        return answer;
    }
}