package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(isException(pobi,crong)){
            return -1;
        }

        int pobiScore= calculateMaxScore(pobi);
        int crongScore= calculateMaxScore(crong);

        if(pobiScore>=crongScore){
            if(pobiScore==crongScore){
                return 0;
            }
            return 1;
        }
        return 2;
    }

    private static int calculateMaxScore(List<Integer> person) {
        List<Integer> leftPageDigits= splitDigits(person.get(0));
        List<Integer> rightPageDigits= splitDigits(person.get(1));

        return findMaxScore(leftPageDigits,rightPageDigits);
    }

    private static boolean isException(List<Integer> pobi, List<Integer> crong){
        return (!isCorrectPage(pobi)) || (!isCorrectPage(crong));
    }

    private static boolean isCorrectPage(List<Integer>pages){ //1
        int pageGap=pages.get(1)-pages.get(0);

        if(pageGap==1) {
            return true;
        }
        return false;
    }

    private static List<Integer> splitDigits(int number){
        return Arrays.stream(Integer.toString(number).split(""))
                .mapToInt(digit->Integer.parseInt(digit))
                .boxed()
                .collect(Collectors.toList());
    }

    private static int getDigitsSum(List<Integer> digits) {
        return digits.stream()
                .mapToInt(i->i)
                .sum();
    }

    private static int getDigitsMultiplication(List<Integer> digits){
        return digits.stream()
                .reduce(1, (a,b)->a*b);
    }

    private static int findMaxScore(List<Integer> leftDigits, List<Integer> rightDigits) {
        int leftDigitsMax=Math.max(getDigitsSum(leftDigits),getDigitsMultiplication(leftDigits));
        int rightDigitsMax=Math.max(getDigitsSum(rightDigits),getDigitsMultiplication(rightDigits));

        if(leftDigitsMax>=rightDigitsMax)return leftDigitsMax;
        return rightDigitsMax;
    }
}