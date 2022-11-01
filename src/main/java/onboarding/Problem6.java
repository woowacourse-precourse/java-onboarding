package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        return answer;
    }

    private static List<String> myTwoNames(String name) {
        List<String> twoNames = new ArrayList<>();
        for (int idx = 0 ; idx < name.length()-1 ; idx++) {
            twoNames.add(name.substring(idx, idx+2));
        }
        return twoNames;
    }

}
