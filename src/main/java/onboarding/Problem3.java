package onboarding;

import java.util.List;

public class Problem3 {

    private static final List<String> criteriaList = List.of(
            new String("3"),
            new String("6"),
            new String("9")
    );

    public static int solution(int number) {
        return getGameResult(number);
    }

    public static int getClapCount(int number) {
        int cnt = 0;
        for (String s : String.valueOf(number).split("")) {
            if (criteriaList.contains(s)) {
                cnt += 1;
            }
        }
        return cnt;
    }

    public static int getGameResult(int endNumber) {
        int result = 0;
        for (int number=1;number<=endNumber;number++){
            result += getClapCount(number);
        }
        return result;
    }

}