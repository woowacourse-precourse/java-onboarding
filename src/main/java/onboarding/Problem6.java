package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {

    public static Map<String, String> createNicknameMap(List<List<String>> forms) {
        HashMap<String, String> nicknameMap = new HashMap<>();

        for (List<String> emailNickname : forms) {
            String email = emailNickname.get(0);
            String nickname = emailNickname.get(1);

            nicknameMap.put(email, nickname);
        }

        return nicknameMap;
    }

    public static Set<String> getDuplicatedEmails(Map<String, String> nicknameMap) {
        HashMap<String, Set<String>> emailsByDoubleCharMap = new HashMap<>();

        nicknameMap.forEach((email, nickname) -> {
            for (int nicknameIdx = 0; nicknameIdx < nickname.length() - 1; nicknameIdx++) {
                String doubleChar = nickname.charAt(nicknameIdx) + "" + nickname.charAt(nicknameIdx + 1);

                // 셋이 없으면 새로 생성
                if (!emailsByDoubleCharMap.containsKey(doubleChar)) {
                    emailsByDoubleCharMap.put(doubleChar, new HashSet<>());
                }

                emailsByDoubleCharMap.get(doubleChar).add(email);
            }
        });

        // 두글자:[이메일]를 순회하며 이메일의 개수가 2개 이상인 것을 찾음
        HashSet<String> duplicatedEmails = new HashSet<>();
        emailsByDoubleCharMap.forEach((doubleChar, emails) -> {
            if (emails.size() >= 2)
                duplicatedEmails.addAll(emails);
        });

        return duplicatedEmails;
    }

    public static List<String> getSortedListBySet(Set<String> set) {
        return set.stream().sorted().collect(Collectors.toList());
    }

    public static List<String> solution(List<List<String>> forms) {
        Map<String, String> nicknameMap = createNicknameMap(forms);
        Set<String> duplicatedEmailSet = getDuplicatedEmails(nicknameMap);
        List<String> duplicatedEmails = getSortedListBySet(duplicatedEmailSet);

        return duplicatedEmails;
    }
}
