package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem6 {
    static Map<String, Integer> nicknameMap;
    static Set<Integer> duplicateNicknameIdxSet;

    public static List<String> solution(List<List<String>> forms) {
        nicknameMap = new HashMap<>();
        duplicateNicknameIdxSet = new HashSet<>();
        findDuplicateNicknames(forms);
        return parseEmails(forms);
    }

    private static List<String> parseEmails(List<List<String>> forms) {
        List<String> emails = new ArrayList<>();
        for (Integer idx : duplicateNicknameIdxSet) {
            String email = forms.get(idx).get(0);
            emails.add(email);
        }
        return emails.stream().sorted().collect(Collectors.toList());
    }

    private static void findDuplicateNicknames(List<List<String>> forms) {
        for (int i = 0; i < forms.size(); i++) {
            List<String> crewForm = forms.get(i);
            String email = crewForm.get(0);
            String nickname = crewForm.get(1);
            if (!validateEmail(email) || !validateNickname(nickname)) {
                continue;
            }
            findDuplicateNickname(nickname, i);
        }
    }

    private static void findDuplicateNickname(String nickname, int idx) {
        for (int i = 0; i < nickname.length() - 1; i++) {
            String twoLetterNickname = nickname.substring(i, i + 2);
            Integer nicknameIdx = nicknameMap.get(twoLetterNickname);
            if (nicknameIdx == null) {
                nicknameMap.put(twoLetterNickname, idx);
                continue;
            }
            duplicateNicknameIdxSet.add(idx);
            duplicateNicknameIdxSet.add(nicknameIdx);
        }
    }

    private static boolean validateEmail(String email) {
        if (email.length() < 11 || email.length() >= 20) {
            return false;
        }

        if (!email.contains("email.com")) {
            return false;
        }

        return true;
    }

    private static boolean validateNickname(String nickname) {
        String expression = "^[ㄱ-ㅎ가-힣]*$";
        if (!nickname.matches(expression)) {
            return false;
        }

        if (nickname.length() < 1 || nickname.length() >= 20) {
            return false;
        }

        return true;
    }
}
