package onboarding;

import java.util.List;

public class Problem6 {
    private static final int EMAIL = 0;
    private static final int NICKNAME = 1;

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static boolean isDuplicate(String subject, String target) {
        String word;

        for (int i = 0; i < subject.length() - 1; i++) {
            word = subject.substring(i, i + 2);

            if (target.contains(word)) {
                return true;
            }
        }

        return false;
    }

    private static boolean[] makeDuplicatedIndexes(List<List<String>> forms) {
        boolean[] duplicatedIndexes = new boolean[forms.size()];

        for (int i = 0; i < forms.size(); i++) {
            String subject = forms.get(i).get(NICKNAME);

            for (int j = 0; j < forms.size(); j++) {
                String target = forms.get(j).get(NICKNAME);

                if (target.equals(subject))
                    continue;

                if (isDuplicate(subject, target)) {
                    duplicatedIndexes[i] = true;
                    duplicatedIndexes[j] = true;
                }
            }
        }

        return duplicatedIndexes;
    }
}
