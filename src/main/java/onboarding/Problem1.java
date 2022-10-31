package onboarding;

import java.util.Arrays;
import java.util.List;


class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(isException(pobi,crong)){
            return -1;
        }

        int[] pobiLeftPageDigits= splitDigits(pobi.get(0));
        int[] pobiRightPageDigits= splitDigits(pobi.get(1));
        int pobiScore= findMaxScore(pobiLeftPageDigits,pobiRightPageDigits);

        int[] crongLeftPageDigits= splitDigits(crong.get(0));
        int[] crongRightPageDigits= splitDigits(crong.get(1));
        int crongScore= findMaxScore(crongLeftPageDigits,crongRightPageDigits);

        if(pobiScore>=crongScore){
            if(pobiScore==crongScore){
                return 0;
            }
            return 1;
        }
        return 2;
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

    private static int[] splitDigits(int number){
        return Arrays.stream(Integer.toString(number).split(""))
                .mapToInt(digit->Integer.parseInt(digit))
                .toArray();
    }

    private static int getDigitsSum(int[] digits) {
        return Arrays.stream(digits)
                .sum();
    }

    private static int getDigitsMultiplication(int[] digits){
        return Arrays.stream(digits)
                .reduce(1, (a,b)->a*b);
    }

    private static int findMaxScore(int[] leftDigits, int[] rightDigits) {
        int leftDigitsMax=Math.max(getDigitsSum(leftDigits),getDigitsMultiplication(leftDigits));
        int rightDigitsMax=Math.max(getDigitsSum(rightDigits),getDigitsMultiplication(rightDigits));

        if(leftDigitsMax>=rightDigitsMax)return leftDigitsMax;
        return rightDigitsMax;
    }
}