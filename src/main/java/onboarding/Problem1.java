package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!validate(pobi) || !validate(crong)) {
            return -1;
        }

        int pobiScore = calculateScore(pobi);
        int crongScore = calculateScore(crong);

        if (pobiScore == crongScore) return 0;
        if (pobiScore > crongScore) return 1;
        return 2;
    }


    private static boolean validate(List<Integer> openedPages) {
        return validatePage(openedPages) && (openedPages.get(0) + 1 == openedPages.get(1));
    }
    private static boolean validatePage(List<Integer> openedPages) {
        Integer leftPage = openedPages.get(0);
        Integer rightPage = openedPages.get(1);
        if (leftPage < 1 || leftPage > 400 || leftPage % 2 == 0) {
            return false;
        }
        if (rightPage < 1 || rightPage > 400 || rightPage % 2 == 1) {
            return false;
        }
        return true;
    }


    private static int calculateScore(List<Integer> player) {
        int leftPage = player.get(0);
        int rightPage = player.get(1);
        return Math.max(maxDigitsSum(leftPage, rightPage), maxDigitsProduct(leftPage, rightPage));
    }
    private static int maxDigitsSum(int leftPage, int rightPage){
        int leftDigitsSum = Arrays.stream(String.valueOf(leftPage).split("")).
                mapToInt(Integer::parseInt).sum();
        int rightDigitsSum = Arrays.stream(String.valueOf(rightPage).split("")).
                mapToInt(Integer::parseInt).sum();
        return Math.max(leftDigitsSum, rightDigitsSum);
    }
    private static int maxDigitsProduct(int leftPage, int rightPage){
        int leftDigitsProduct = Arrays.stream(String.valueOf(leftPage).split("")).
                mapToInt(Integer::parseInt).reduce(1, (x,y)->x*y);
        int rightDigitsProduct = Arrays.stream(String.valueOf(rightPage).split("")).
                mapToInt(Integer::parseInt).reduce(1, (x,y)->x*y);
        return Math.max(leftDigitsProduct, rightDigitsProduct);
    }
}