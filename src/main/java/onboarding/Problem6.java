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

        for (String nickname : refinedCrewForms.keySet()) {
            generateDuplicatedNicknameCandidate(nickname, duplicatedNicknameCandidate);
        }

        List<String> compareNames = generateCompareNickname(duplicatedNicknameCandidate);

        List<String> results = generateResults(forms, compareNames);
        Collections.sort(results);

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

    private static void generateDuplicatedNicknameCandidate(String nickname, Map<String, Integer> duplicatedNicknameCandidate) {
        for (int i = 0; i < nickname.length() - 1; i++) {
            for (int j = i + 2; j <= nickname.length(); j++) {
                String substring = nickname.substring(i, j);
                duplicatedNicknameCandidate.put(substring, duplicatedNicknameCandidate.getOrDefault(substring, 0) + 1);
            }
        }
    }

    private static List<String> generateCompareNickname(Map<String, Integer> duplicatedNicknameCandidate) {
        List<String> compareNickname = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : duplicatedNicknameCandidate.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();

            if (value > 1) {
                compareNickname.add(key);
            }
        }

        return compareNickname;
    }

    private static List<String> generateResults(List<List<String>> forms, List<String> compareNicknames) {
        List<String> results = new ArrayList<>();

        for (List<String> form : forms) {
            String nickname = form.get(1);
            for (String compareNickname : compareNicknames) {
                if (containNickname(nickname, compareNickname)) {
                    results.add(form.get(0));
                }
            }
        }
        return results;
    }

    private static boolean containNickname(String name, String compareNickname) {
        for (int i = 0; i < name.length() - 1; i++) {
            String substring = name.substring(i, i + 2);
            if (substring.equals(compareNickname)) {
                return true;
            }
        }
        return false;
    }
}