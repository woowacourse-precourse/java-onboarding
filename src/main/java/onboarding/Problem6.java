package onboarding;

import java.util.*;
import java.util.regex.Pattern;

public class Problem6 {

    private static final String KOREAN = ".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*";
    private static final String ATSIGN = "@";
    private static final String DOMAIN = "email.com";

    public static List<String> solution(List<List<String>> forms) {
        Map<String, List<String>> refinedCrewForms = new HashMap<>();
        Map<String, Integer> duplicatedNicknameCandidate = new HashMap<>();

        validateRegistrationForms(forms, refinedCrewForms);

        return results;
    }

    private static void validateRegistrationForms(List<List<String>> forms, Map<String, List<String>> refinedCrewForms) {
        for (List<String> form : forms) {
            String nickname = form.get(1);
            String email = form.get(0);

            refinedCrewForms.put(nickname, refinedCrewForms.getOrDefault(nickname, new ArrayList<>()));

            if (isSatisFiedNicknameFormat(nickname) && isSatisfiedEmailFormat(email)) {
                refinedCrewForms.get(nickname).add(email);
            }
        }
    }

    private static boolean isSatisFiedNicknameFormat(String nickname) {
        if (nickname.length() < 1 || nickname.length() >= 20) {
            return false;
        }
        return Pattern.matches(KOREAN, nickname);
    }

    private static boolean isSatisfiedEmailFormat(String email) {
        if (email.length() < 11 || email.length() >= 20) {
            return false;
        }

        return email.split(ATSIGN)[1].equals(DOMAIN);
    }
}