package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


class Problem1 {
    public static int solution(final List<Integer> pobi, final List<Integer> crong) {
        if(isException(pobi,crong)){
            return -1;
        }

        final int pobiScore= calculateMaxScore(pobi);
        final int crongScore= calculateMaxScore(crong);

        if(pobiScore>=crongScore){
            if(pobiScore==crongScore){
                return 0;
            }
            return 1;
        }
        return 2;
    }

    private static int calculateMaxScore(final List<Integer> person) {
        List<Integer> leftPageDigits= splitDigits(person.get(0));
        List<Integer> rightPageDigits= splitDigits(person.get(1));

        return findMaxScore(leftPageDigits,rightPageDigits);
    }

    private static boolean isException(final List<Integer> pobi, final List<Integer> crong){
        return (!isCorrectPage(pobi)) || (!isCorrectPage(crong));
    }

    private static boolean isCorrectPage(List<Integer>pages){ //1
        final int pageGap=pages.get(1)-pages.get(0);

        if(pageGap==1) {
            return true;
        }
        return false;
    }

    private static List<Integer> splitDigits(final int number){
        return Arrays.stream(Integer.toString(number).split(""))
                .mapToInt(digit->Integer.parseInt(digit))
                .boxed()
                .collect(Collectors.toList());
    }

    private static int getDigitsSum(final List<Integer> digits) {
        return digits.stream()
                .mapToInt(i->i)
                .sum();
    }

    private static int getDigitsMultiplication(final List<Integer> digits){
        return digits.stream()
                .reduce(1, (a,b)->a*b);
    }

    private static int findMaxScore(final List<Integer> leftDigits, final List<Integer> rightDigits) {
        final int leftDigitsMax=Math.max(getDigitsSum(leftDigits),getDigitsMultiplication(leftDigits));
        final int rightDigitsMax=Math.max(getDigitsSum(rightDigits),getDigitsMultiplication(rightDigits));

        if(leftDigitsMax>=rightDigitsMax)return leftDigitsMax;
        return rightDigitsMax;
    }
}