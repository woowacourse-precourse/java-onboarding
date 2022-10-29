package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    private static final int CLAP_CONDITION1 = 3;
    private static final int CLAP_CONDITION2 = 6;
    private static final int CLAP_CONDITION3 = 9;

    public static int solution(int number) {
        int answer = 0;
        return answer;
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
}
