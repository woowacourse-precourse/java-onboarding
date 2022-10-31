package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Problem3 {
    private static final int CLAP_CONDITION1 = 3;
    private static final int CLAP_CONDITION2 = 6;
    private static final int CLAP_CONDITION3 = 9;

    public static int solution(int number) {
        return getTotalClapSum(number);
    }

    private static int getTotalClapSum(int number) {
        return IntStream.range(1, number + 1)
                .map(Problem3::checkClapNumber)
                .sum();
    }

    private static List<Integer> splitDigitNumber(int number) {
        List<Integer> splitNumberList = new ArrayList<>();
        while (number > 0) {
            splitNumberList.add(number % 10);
            number /= 10;
        }
        return splitNumberList;
    }

    private static boolean isClapNumber(int number) {
        return number == CLAP_CONDITION1 || number == CLAP_CONDITION2 || number == CLAP_CONDITION3;
    }

    private static int checkClapNumber(int number) {
        List<Integer> splitNumberList = splitDigitNumber(number);
        int clapSum = 0;
        for (int splitNumber : splitNumberList) {
            if (isClapNumber(splitNumber)) {
                clapSum = addClapSum(clapSum);
            }
        }
        return clapSum;
    }

    private static int addClapSum(int clapCnt) {
        return clapCnt + 1;
    }
}
