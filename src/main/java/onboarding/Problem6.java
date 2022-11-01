package onboarding;

import java.util.*;

public class Problem6 {
    private static final String EMAIL_DOMAIN = "@mail.com";

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        Map<String, Integer> nicknameSubstringCounts = new HashMap<>();
        Set<String> emails = new HashSet<>();

        countNickname(forms, nicknameSubstringCounts);

        findEmailByDuplicatedNickname(forms, nicknameSubstringCounts, emails);

        answer = new ArrayList<>(emails);

        // 이메일 오름차순으로 정렬
        Collections.sort(answer, (str1, str2) -> {
            String mail1 = str1.split(EMAIL_DOMAIN)[0];
            String mail2 = str2.split(EMAIL_DOMAIN)[0];

            return mail1.compareTo(mail2);
        });

        return answer;
    }

    // 닉네임이 중복된 사람의 이메일 얻기
    private static void findEmailByDuplicatedNickname(List<List<String>> forms, Map<String, Integer> nicknameSubstringCounts, Set<String> emails) {
        for (String substring : nicknameSubstringCounts.keySet()) {
            if (nicknameSubstringCounts.get(substring) > 1) {
                addEmailByDuplicatedNickname(forms, emails, substring);
            }
        }
    }

    private static void addEmailByDuplicatedNickname(List<List<String>> forms, Set<String> emails, String substring) {
        for (List<String> form : forms) {
            String nickname = form.get(1);

            if (nickname.contains(substring)) {
                String email = form.get(0);

                emails.add(email);
            }
        }
    }

    private static void countNickname(List<List<String>> forms, Map<String, Integer> nicknameSubstringCounts) {
        for (List<String> form : forms) {
            String nickname = form.get(1);

            countSubstring(nicknameSubstringCounts, nickname);
        }
    }

    // 현재 닉네임에서 2글자 이상 연속된 부분문자열의 사용횟수
    public static void countSubstring(Map<String, Integer> nicknameSubstringCounts, String nickname) {
        // 문자열 개수
        for (int i = 2; i < nickname.length(); i++) {
            countSubStringByLength(nicknameSubstringCounts, nickname, i);
        }
    }

    // 해당 길이 부분문자열 카운팅
    private static void countSubStringByLength(Map<String, Integer> nicknameSubstringCounts, String nickname, int length) {
        // 시작점
        for (int i = 0; i <= nickname.length() - length; i++) {
            String subString = nickname.substring(i, i + length);
            int count = nicknameSubstringCounts.getOrDefault(subString, 0) + 1;

            nicknameSubstringCounts.put(subString, count);
        }
    }
}
