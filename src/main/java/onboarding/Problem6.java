package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        for (List<String> userInfo : forms) {
            int checkIndex = userInfo.get(1).length() - 1;
            checkDuplicate(checkIndex, userInfo);

        }

        return answer;
    }

    private static void checkDuplicate(int checkIndex, List<String> userInfo) {
        for (int j = 0; j < checkIndex; j++) {
            String checkTwoLetter = userInfo.get(1).substring(j, j + 2);
            System.out.println(checkTwoLetter);
        }
    }
}
