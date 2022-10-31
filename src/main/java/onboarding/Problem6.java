package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();



        return answer;
    }

    private static boolean checkSimilarNickname(String name1, String name2) {
        for (int i = 0; i < name1.length() - 1; i++) {
            for (int j = 0; j < name2.length() - 1; j++) {
                if (name1.charAt(i) == name2.charAt(j) && name1.charAt(i + 1) == name2.charAt(j + 1)) {
                    return true;
                }
            }
        }
        return false;
    }



}
