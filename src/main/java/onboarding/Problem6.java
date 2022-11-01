package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem6 {
    static Map<String, Integer> nicknames;
    static Set<Integer> duplicateNicknameIndexes;

    public static List<String> solution(List<List<String>> forms) {
        nicknames = new HashMap<>();
        duplicateNicknameIndexes = new HashSet<>();
        findDuplicationNicknames(forms);
        return parseEmails(forms);
    }

    private static List<String> parseEmails(List<List<String>> forms) {
        List<String> emails = new ArrayList<>();
        for (Integer idx : duplicateNicknameIndexes) {
            String email = forms.get(idx).get(0);
            emails.add(email);
        }
        return emails.stream().sorted().collect(Collectors.toList());
    }

    private static void findDuplicationNicknames(List<List<String>> forms) {
        for (int i = 0; i < forms.size(); i++) {
            List<String> crewForm = forms.get(i);
            String email = crewForm.get(0);
            String nickname = crewForm.get(1);
            validateEmail(email);
            validateNickname(nickname);
            findDuplicationNickname(nickname, i);
        }
    }

    private static void findDuplicationNickname(String nickname, int idx) {
        for (int i = 0; i < nickname.length() - 1; i++) {
            String twoLetterNickname = nickname.substring(i, i + 2);
            Integer nicknameIdx = nicknames.get(twoLetterNickname);
            if (nicknameIdx == null) {
                nicknames.put(twoLetterNickname, idx);
                continue;
            }
            duplicateNicknameIndexes.add(idx);
            duplicateNicknameIndexes.add(nicknameIdx);
        }
    }

    private static void validateEmail(String email) {
        if (email.length() < 11 || email.length() >= 20) {
            throw new IllegalArgumentException("이메일의 길이는 11이상 20미만이어야 합니다.");
        }

        if (!email.contains("email.com")) {
            throw new IllegalArgumentException("도메인은 email.com만 가능합니다.");
        }
    }

    private static void validateNickname(String nickname) {
        String expression = "^[ㄱ-ㅎ가-힣]*$";
        if (!nickname.matches(expression)) {
            throw new IllegalArgumentException("닉네임은 한글만 가능합니다.");
        }

        if (nickname.length() < 1 || nickname.length() >= 20) {
            throw new IllegalArgumentException("닉네임의 길이는 1이상 20미만이어야 합니다.");
        }
    }
}
