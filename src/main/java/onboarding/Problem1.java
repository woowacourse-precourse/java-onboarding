package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!isCorrect(pobi) || !isCorrect(crong)) return -1;

        int pobiScore = score(pobi);
        int crongScore = score(crong);

        if(pobiScore == crongScore) return 0;
        return pobiScore > crongScore ? 1 : 2;
    }

    private static boolean isCorrect(List<Integer> player) {
        Integer leftPage = player.get(0);
        Integer rightPage = player.get(1);
        if(rightPage-leftPage!=1) return false;
        if(leftPage < 1 || rightPage > 400) return false;
        return true;
    }

    static int score(List<Integer> player) {
        int leftPage = player.get(0);
        int rightPage = player.get(1);
        int maxDigitSum = Math.max(sumDigits(leftPage), sumDigits(rightPage));
        int maxDigitProduct = Math.max(productDigits(leftPage), productDigits(rightPage));

        return Math.max(maxDigitSum, maxDigitProduct);
    }

    static int sumDigits(int page){
        String[] digits = String.valueOf(page).split("");
        return Arrays.stream(digits).mapToInt(Integer::parseInt).sum();
    }

    static int productDigits(int page){
        String[] digits = String.valueOf(page).split("");
        return Arrays.stream(digits).mapToInt(Integer::parseInt).reduce(1, (x,y)->x*y);
    }
}