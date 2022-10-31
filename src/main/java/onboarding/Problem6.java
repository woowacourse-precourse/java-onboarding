package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem6 {

    public static final String CORRECT_DOMAIN = "email.com";
    public static final String EMAIL_DELIM = "@";
    public static final String KOREAN_REGEX = ".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*";

    public static List<String> solution(List<List<String>> forms) {
        Map<String, List<String>> crewInfo = new HashMap<>();
        Map<String, Integer> duplicatedNicknameCandidate = new HashMap<>();
        Set<String> duplicatedNicknameSet = new HashSet<>();

        initCrewInfo(forms, crewInfo);

        for (String nickname : crewInfo.keySet()) {
            initDuplicatedNicknameCandidate(nickname, duplicatedNicknameCandidate);
        }

        for (String nickname : crewInfo.keySet()) {
            if (hasMoreThanOnceDuplicatedCount(nickname, duplicatedNicknameCandidate)) {
                duplicatedNicknameSet.add(nickname);
            }
        }

        List<String> answer = duplicatedNicknameSet.stream()
                                                   .flatMap(nickname -> crewInfo.get(nickname)
                                                                                .stream())
                                                   .sorted()
                                                   .collect(Collectors.toList());

        return answer;
    }

    private static void initCrewInfo(List<List<String>> forms,
                                     Map<String, List<String>> crewInfo) {
        for (List<String> form : forms) {
            String nickname = form.get(1);
            String email = form.get(0);

            crewInfo.computeIfAbsent(nickname, k -> new ArrayList<>());

            if (isSatisfyEmailFormat(email) && isSatisfyNicknameFormat(nickname)) {
                crewInfo.get(nickname)
                        .add(email);
            }
        }
    }

    private static void initDuplicatedNicknameCandidate(String nickname,
                                                        Map<String, Integer> duplicatedNicknameCandidate) {
        for (int i = 0; i < nickname.length() - 1; i++) {
            for (int j = i + 2; j <= nickname.length(); j++) {
                String substring = nickname.substring(i, j);

                duplicatedNicknameCandidate.put(substring,
                        duplicatedNicknameCandidate.getOrDefault(substring, 0) + 1);
            }
        }
    }

    private static boolean hasMoreThanOnceDuplicatedCount(String nickname,
                                                          Map<String, Integer> duplicatedNicknameCandidate) {
        for (int i = 0; i < nickname.length() - 1; i++) {
            for (int j = i + 2; j <= nickname.length(); j++) {
                String substring = nickname.substring(i, j);

                if (duplicatedNicknameCandidate.get(substring) > 1) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isSatisfyEmailFormat(String email) {
        int emailLength = email.length();

        if (emailLength < 11 || emailLength >= 20) {
            return false;
        }

        String[] parsedEmail = email.split(EMAIL_DELIM);
        String domain = parsedEmail[1];

        return domain.equals(CORRECT_DOMAIN);
    }

    private static boolean isSatisfyNicknameFormat(String nickname) {
        int nicknameLength = nickname.length();

        if (nicknameLength < 1 || nicknameLength >= 20) {
            return false;
        }

        return Pattern.matches(KOREAN_REGEX, nickname);
    }
}
