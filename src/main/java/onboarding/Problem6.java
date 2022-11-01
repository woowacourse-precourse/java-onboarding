package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> splitString(String nickname) {
        List<String> fragment = new ArrayList<>();
        for (int i = 0; i < nickname.length() - 1; i++)
            fragment.add(nickname.substring(i, i + 2));
        return fragment;
    }

    public static boolean searchSameSeq(String nickname, List<String> fragments) {
        for (String frag : fragments)
            if (nickname.contains(frag)) return true;
        return false;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
