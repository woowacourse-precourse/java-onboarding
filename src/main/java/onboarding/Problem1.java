package onboarding;

import java.util.List;

class Problem1 {
    public static int computeMaxSumMul(int num){
        int numSum = 0;
        int numMul = 1;

        while(num != 0){
            numSum += num % 10;
            numMul *= num % 10;
            num /= 10;
        }

        return Math.max(numSum, numMul);
    }

    public static int computeMaxScore(List<Integer> pages) {
        int leftMaxScore = computeMaxSumMul(pages.get(0));
        int rightMaxScore = computeMaxSumMul(pages.get(1));

        return Math.max(leftMaxScore, rightMaxScore);
    }

    public static boolean validateParam(List<Integer> pages){
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        return (rightPage - leftPage) == 1 ? true : false;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(!validateParam(pobi) || !validateParam(crong)) {
            return -1;
        }

        int pobiScore = computeMaxScore(pobi);
        int crongScore = computeMaxScore(crong);

        if(pobiScore > crongScore) {
            return 1;
        } else if(pobiScore < crongScore) {
            return 2;
        }

        return 0;
    }
}