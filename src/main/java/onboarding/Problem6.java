package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String, String> crewInfo = new HashMap<>();
        Map<String, Integer> duplicatedNicknameCandidate = new HashMap<>();
        Set<String> duplicatedNicknameSet = new HashSet<>();

        initializationCrewInfo(forms, crewInfo);

        for (String nickname : crewInfo.keySet()) {
            initializationDuplicatedNicknameCandidate(nickname, duplicatedNicknameCandidate);
        }

        for (String nickname : crewInfo.keySet()) {
            if (hasMoreThanOnceDuplicatedCount(nickname, duplicatedNicknameCandidate)) {
                duplicatedNicknameSet.add(nickname);
            }
        }

        List<String> answer = duplicatedNicknameSet.stream()
                                                   .map(crewInfo::get)
                                                   .sorted()
                                                   .collect(Collectors.toList());

        return answer;
    }

    private static void initializationCrewInfo(List<List<String>> forms,
                                               Map<String, String> crewInfo) {
        for (List<String> form : forms) {
            String nickname = form.get(1);
            String email = form.get(0);

            if (isSatisfyEmailFormat(email) && isSatisfyNicknameFormat(nickname)) {
                System.out.println("nickname = " + nickname);
                crewInfo.put(nickname, email);
            }
        }
    }

    private static void initializationDuplicatedNicknameCandidate(String nickname,
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

        if (emailLength < 11 || emailLength > 20) {
            return false;
        }

        String[] parsedEmail = email.split("@");
        String domain = parsedEmail[1];

        return domain.equals("email.com");
    }

    private static boolean isSatisfyNicknameFormat(String nickname) {
        int nicknameLength = nickname.length();

        if (nicknameLength < 1 || nicknameLength >= 20) {
            return false;
        }

        return Pattern.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*", nickname);
    }
}
