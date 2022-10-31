package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static void main(String[] args) {


    }

    static boolean isValidIdLength(int n) {
        return n >= 1 && n <= 30;
    }

    static boolean isValidId(String s) {
        boolean result = true;
        for (int i = 0; i <s.length() ; i++) {
            result =isSmallLetter(s.charAt(i),result);
        }
        return result;
    }

    private static boolean isSmallLetter(char c, boolean result) {
        if (!result) {
            return false;
        }

        return c >= 'a' && c <= 'z';
    }

    static boolean isValidFriendsListLength(int n) {
        return n >= 1 && n <= 10_000;
    }

    static boolean isValidVisitorsListLength(int n) {
        return n >= 1 && n <= 10_000;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
