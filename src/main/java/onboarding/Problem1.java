package onboarding;

import java.util.List;
import java.util.stream.*;


class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(isIncorrectPageValue(pobi) || isIncorrectPageValue(crong)) return(-1);
        int answer = Integer.MAX_VALUE;
        int[] pobiLeftPageArray = integerSeparateToEachDigit(pobi.get(0));
        int[] pobiRightPageArray = integerSeparateToEachDigit(pobi.get(1));
        int pobiMax = findMaxValue(pobiLeftPageArray, pobiRightPageArray);

        int[] crongLeftPageArray = integerSeparateToEachDigit(crong.get(0));
        int[] crongRightPageArray = integerSeparateToEachDigit(crong.get(1));
        int crongMax = findMaxValue(crongLeftPageArray, crongRightPageArray);

        if(pobiMax == crongMax) answer = 0;
        else if(pobiMax > crongMax) answer = 1;
        else answer = 2;
        return answer;
    }

    public static boolean isIncorrectPageValue(List<Integer> pages){
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        if(leftPage % 2 == 0 || rightPage % 2 == 1) return true;
        if(leftPage <= 0 || leftPage >= 400) return true;
        if(rightPage <= 0 || rightPage > 400) return true;
        if(leftPage != rightPage-1) return true;
        return false;
    }

    public static int[] integerSeparateToEachDigit(int number){
        return(Stream.of(Integer.toString(number).split("")).mapToInt(Integer::parseInt).toArray());
    }

    public static int findMaxValue(int[] leftPage, int[] rightPage){
        int leftPageMaxValue = Integer.MAX_VALUE;
        int rightPageMaxValue = Integer.MAX_VALUE;
        leftPageMaxValue = Math.max(addEachDigit(leftPage), multiplicationOfEachDigit(leftPage));
        rightPageMaxValue = Math.max(addEachDigit(rightPage), multiplicationOfEachDigit(rightPage));

        return Math.max(leftPageMaxValue, rightPageMaxValue);
    }

    public static int addEachDigit(int[] integerArray){
        return(IntStream.of(integerArray).sum());
    }

    public static int multiplicationOfEachDigit(int[] integerArray){
        return(IntStream.of(integerArray).reduce(1, (a,b) -> a*b));
    }
}