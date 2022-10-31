package onboarding;

import java.util.*;

public class Problem6 {

    private static final int EMAIL_INDEX_OF_FORM = 0;
    private static final int NICKNAME_INDEX_OF_FORM = 1;
    private static final String EMAIL_CHECK = "@";
    private static final String EMAIL_RULE = "@email.com";

    public static List<String> solution(List<List<String>> forms) {
        Map<String, String> namesAlreadyApplied = new HashMap<>();
        Set<String> emails = new TreeSet<>();

        for (List<String> form : forms) {
            String email = form.get(EMAIL_INDEX_OF_FORM);
            String nickname = form.get(NICKNAME_INDEX_OF_FORM);

            if (!email.contains(EMAIL_CHECK)) {
                String positionConverter = nickname;
                nickname = email;
                email = positionConverter;
            }

            if (!email.endsWith(EMAIL_RULE)) {
                continue;
            }

            if (nickname.length() == 1) {
                continue;
            }

            Set<String> nicknameCombinations = new HashSet<>();
        }

        List<String> answer = List.of("answer");
        return answer;
    }

}
