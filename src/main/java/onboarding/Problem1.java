package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        //When incorrect input
        if (!isCorrect(pobi) || !isCorrect(crong)) return -1;

        //Calculating scores respectively
        int pobiScore = score(pobi);
        int crongScore = score(crong);

        //Judging winner
        if(pobiScore == crongScore) return 0;
        else return pobiScore > crongScore ? 1 : 2;
    }

    private static boolean isCorrect(List<Integer> person) {
        int leftPage = person.get(0);
        int rightPage = person.get(1);
        if(rightPage-leftPage!=1 || rightPage%2 != 0 || rightPage<1) return false;
        return true;
    }

    static int score(List<Integer> person) {
        int leftPage = person.get(0);
        int rightPage = person.get(1);

        int maxDigitSum = Math.max(digitSum(leftPage), digitSum(rightPage));
        int maxDigitProduct = Math.max(digitProduct(leftPage), digitProduct(rightPage));

        return Math.max(maxDigitSum, maxDigitProduct);
    }

    static int digitSum(int n){
        String[] digits = String.valueOf(n).split("");
        return Arrays.stream(digits).
                mapToInt(Integer::parseInt).sum();
    }

    static int digitProduct(int n){
        String[] digits = String.valueOf(n).split("");
        return Arrays.stream(digits).
                mapToInt(Integer::parseInt).reduce(1, (x,y)->x*y);
    }
}