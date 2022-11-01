package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static List<String> fragmentNN(String nickName) {
        List<String> ret = new ArrayList<>();

        for (int i = 0; i < nickName.length() - 1; i++) {
            String subString = nickName.substring(i, i + 2);
            ret.add(subString);
        }

        return ret;
    }

}
