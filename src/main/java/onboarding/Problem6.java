package onboarding;

import java.util.*;
import java.util.regex.Pattern;

public class Problem6 {

    private static final int EMAIL_INDEX_OF_FORM = 0;
    private static final int NICKNAME_INDEX_OF_FORM = 1;
    private static final String EMAIL_CHECK = "@";
    private static final String EMAIL_RULE = "@email.com";
    private static final int NAME_DUPLICATE_LENGTH_RULE = 2;
    private static final String KOREAN_CHECK_REGEX = "^[ㄱ-ㅎㅏ-ㅣ가-힣]*$";

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
            for (int i = 0; i < nickname.length() - 1; i++) {
                String partialNickname = nickname.substring(i, i + NAME_DUPLICATE_LENGTH_RULE);

                if (isKorean(partialNickname)) {

                    if (namesAlreadyApplied.containsKey(partialNickname)
                            && !nicknameCombinations.contains(partialNickname)) {

                        emails.add(email);
                        String appliedFirstEmail = namesAlreadyApplied.get(partialNickname);
                        emails.add(appliedFirstEmail);
                    }
                }
            }
        }

        List<String> answer = List.of("answer");
        return answer;
    }

    private static boolean isKorean(String word) {
        return Pattern.matches(KOREAN_CHECK_REGEX, word);
    }

}
