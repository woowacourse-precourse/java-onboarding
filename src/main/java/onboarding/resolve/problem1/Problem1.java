package onboarding.resolve.problem1;

import java.util.ArrayList;
import java.util.List;

public class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!ExceptionHandler.validateInput(pobi) || !ExceptionHandler.validateInput(crong)) {
            return Constants.EXCEPTION;
        }
        Integer pobiScore = getScore(pobi);
        Integer crongScore = getScore(crong);
        return getWinner(pobiScore,crongScore);
    }

    private static int getWinner(Integer pobiScore, Integer crongScore) {
        if (pobiScore > crongScore) {
            return Constants.POBI_WIN;
        }
        if (crongScore > pobiScore) {
            return Constants.CRONG_WIN;
        }
        return Constants.TIE;
    }

    private static Integer getScore(List<Integer> pobi) {
        List<Integer> left = splitInt(pobi.get(0));
        List<Integer> right = splitInt(pobi.get(1));
        int sumMax = Integer.max(getSum(left),getSum(right));
        int mulMax = Integer.max(getMul(left),getMul(right));

        return Integer.max(sumMax,mulMax);
    }

    private static int getMul(List<Integer> splitInts) {
        int mulInt = 1;
        for (Integer splitInt : splitInts) {
            mulInt *= splitInt;
        }
        return mulInt;
    }

    private static int getSum(List<Integer> splitInts) {
        int sumInt = 0;
        for (Integer splitInt : splitInts) {
            sumInt += splitInt;
        }
        return sumInt;
    }

    private static List<Integer> splitInt(Integer num) {
        List<Integer> splitInts = new ArrayList<>();
        while(num > 0) {
            splitInts.add(num%10);
            num /= 10;
        }
        return splitInts;
    }


}
