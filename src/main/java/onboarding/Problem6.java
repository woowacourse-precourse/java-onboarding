package onboarding;

import java.util.*;

public class Problem6 {
    public static final int EMAIL = 0;
    public static final int NICKNAME = 1;

    public static HashMap<String, String> crews;

    public static List<String> solution(List<List<String>> forms) {
        crews = toHashMap(forms);

        return answer;
    }

    public static HashMap<String, String> toHashMap(List<List<String>> forms) {
        HashMap<String, String> crewInfo = new HashMap<>();
        for(List<String> crew : forms) {
            crewInfo.putIfAbsent(crew.get(NICKNAME), crew.get(EMAIL));
        }
        return crewInfo;
    }
}
