package onboarding;

import java.util.List;

class Problem1 {
    private static int sumOfDigit(int num) {
        int sum = 0;
        while(num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    private static int multiplyOfDigit(int num) {
        int multiply = 1;
        while(num > 0) {
            multiply *= num % 10;
            num /= 10;
        }
        return multiply;
    }

    private static int getMaxScore(List<Integer> pages) {
        int maxScore = 0;
        for(int page : pages) {
            if(sumOfDigit(page) == 0 || multiplyOfDigit(page) == 0) return -1;

            int newScore = Math.max(sumOfDigit(page), multiplyOfDigit(page));
            maxScore = Math.max(newScore, maxScore);
        }

        return maxScore;
    }

    private static int getPageNumberGameResult(int pobiScore, int crongScore) {
        if( pobiScore == -1 || crongScore == -1 ) return -1;
        if( pobiScore > crongScore ) return 1;
        else if( pobiScore < crongScore ) return 2;
        else return 0;
    }

    public static int solution(List<Integer> pobi,
                               List<Integer> crong) {
        int pobiMaxScore = Integer.MIN_VALUE,
            crongMaxScore = Integer.MIN_VALUE;

        pobiMaxScore = getMaxScore(pobi);
        crongMaxScore = getMaxScore(crong);

        return getPageNumberGameResult(pobiMaxScore, crongMaxScore);
    }
}