package onboarding;

import java.util.List;

class Problem1 {
    public static boolean checkPages(List<Integer> pages) {
        int firstPage = 0;
        int lastPage = 400;

        if ((pages.get(0) % 2) == 0) {
            return false;
        }
        if ((pages.get(1) % 2) == 1) {
            return false;
        }
        if (pages.get(1) - pages.get(0) != 1) {
            return false;
        }
        if (pages.get(0) < firstPage || pages.get(0) > lastPage || pages.get(1) < firstPage || pages.get(1) > lastPage) {
            return false;
        }

        return true;
    }

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
        int execption = -1;
        int pobiScore;
        int crongScore;

        if ((checkPages(pobi) == false) || (checkPages(crong) == false)) {
            return execption;
        }
        pobiScore = Math.max(getLeftPageScore(pobi), getRightPageScore(pobi));
        crongScore = Math.max(getLeftPageScore(crong), getRightPageScore(crong));
        answer = findWinner(pobiScore, crongScore);

        return answer;
    }
}