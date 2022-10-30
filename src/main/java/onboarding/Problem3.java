package onboarding;

import java.util.Arrays;
import java.util.List;

public class Problem3 {
    static final List<String> targetNumList = Arrays.asList("3", "6", "9");

    public static int solution(int number) {
        int answer = getTotalTargetNumCnt(number);

        return answer;
    }

    static int getTotalTargetNumCnt(int number) {
        int totalTargetNumCnt = 0;

        for (int i = 1; i <= number; i++) {
            totalTargetNumCnt += getTargetNumCnt(i);
        }

        return totalTargetNumCnt;
    }

    static int getTargetNumCnt(int number) {
        String StringNum = Integer.toString(number);
        String[] StringNumArr = StringNum.split("");

        int targetNumCnt = (int) Arrays.stream(StringNumArr)
                .filter(num -> targetNumList.contains(num))
                .count();

        return targetNumCnt;
    }
}
