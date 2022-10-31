package onboarding;

import java.util.*;

public class Problem6 {
    private static Map<String, String> sequenceNamesMap = new HashMap<>();

    public static List<String> solution(List<List<String>> forms) {

        for (int i = 0; i < forms.size(); i++) {
            List<String> crew = forms.get(i);
            addSequenceName(crew);
        }

        List<String> answer = List.of("answer");
        return answer;
    }

    private static void addSequenceName(List<String> crew) {

        String email = crew.get(0);
        String name = crew.get(1);
        for (int i = 1; i < name.length(); i++) {
            String sequenceName = name.substring(i - 1, i + 1);

            if (isDuplicateName(sequenceName)) {

            }

            sequenceNamesMap.put(sequenceName, email);
        }

    }

    private static boolean isDuplicateName(String sequenceName) {

        if (sequenceNamesMap.get(sequenceName) == null) {
            return false;
        } else {
            return true;
        }

    }

}
