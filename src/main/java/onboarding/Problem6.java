package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        for (List e : forms) {

        }

        return answer;
    }

    private static Boolean isThereMatch(List<List<String>> forms, String keyword) {
        String regex = ".*("+keyword+")+.*";
        for (List<String> e : forms) {
            System.out.println(e);
            String nickname = e.get(1);
            Boolean result = nickname.matches(regex);
            if (result == true) {
                return true;
            }
        }
        return false;
    }
}
