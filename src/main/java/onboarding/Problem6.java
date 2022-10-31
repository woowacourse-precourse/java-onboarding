package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {

    /**
     * @param forms : 주어진 forms
     * @return List<String> : 사용자 email 담은 list
     */
    public static List<String> getEmailsFromForms(List<List<String>> forms) {
        List<String> emails = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            emails.add(forms.get(i).get(0));
        }
        return emails;
    }

    /**
     * @param forms : 주어진 forms
     * @return List<String> : 사용자 nickname 담은 list
     */
    public static List<String> getNicknamesFromForms(List<List<String>> forms) {
        List<String> emails = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            emails.add(forms.get(i).get(1));
        }
        return emails;
    }

    /**
     * @param nicknames : 사용자 nickname list
     * @return Set<String> : 중복되는 substring list
     */
    public static Set<String> getDuplicatedSubstringSet(List<String> nicknames) {
        Set<String> allNicknameSubstringSet = new HashSet<>();
        Set<String> duplicatedSubstringSet = new HashSet<>();
        // all nicknames
        for (int i = 0; i < nicknames.size(); i++) {
            // 중복 없는 nickname[i]의 substring 집합
            Set<String> nicknameSubstringSet = new HashSet<>();
            for (int j = 0; j < nicknames.get(i).length() - 1; j++) {
                nicknameSubstringSet.add(nicknames.get(i).substring(j, j + 2));
            }
            // nickname[i]의 모든 substring 집합에 대해
            for (String nicknameSubstring : nicknameSubstringSet) {
                // 전체 닉네임 substring 집합에 이미 존재할 경우 중복
                if (allNicknameSubstringSet.contains(nicknameSubstring)) {
                    duplicatedSubstringSet.add(nicknameSubstring);
                } else { // 처음 들어올 경우 중복이 아님
                    allNicknameSubstringSet.add(nicknameSubstring);
                }
            }
        }
        return duplicatedSubstringSet;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
