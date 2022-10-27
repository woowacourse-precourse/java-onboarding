package onboarding;

import java.util.*;

public class Problem6 {
    private static Map<String, String> crews = new HashMap<>();
    private static Map<String, Integer> nameTokens = new HashMap<>();

    public static List<String> solution(List<List<String>> forms) {
        crewToMap(forms);
    }

    private static void crewToMap(List<List<String>> forms) {
        for (List<String> id : forms) {
            String name = id.get(1);
            crews.put(name, id.get(0));
            sliceName(name);
        }
    }

    private static void sliceName(String name) {
        for (int i = 0; i < name.length() - 1; i++) {
            String nameToken = name.substring(i, i + 2);
            nameTokens.put(nameToken, nameTokens.getOrDefault(nameToken, 0) + 1);
        }
    }

}
