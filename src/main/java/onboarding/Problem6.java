package onboarding;

import java.util.*;

public class Problem6 {

    public static final int FORM_EMAIL_INDEX = 0;
    public static final int FORM_NICKNAME_INDEX = 1;
    public static final int SUBSTRING_LENGTH = 2;

    /**
     * @param forms : 주어진 forms
     * @return List<String> : 사용자 email 담은 list
     */
    public static List<String> getEmailsFromForms(List<List<String>> forms) {
        List<String> emails = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            emails.add(forms.get(i).get(FORM_EMAIL_INDEX));
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
            emails.add(forms.get(i).get(FORM_NICKNAME_INDEX));
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
            for (int j = 0; j < nicknames.get(i).length() - (SUBSTRING_LENGTH - 1); j++) {
                nicknameSubstringSet.add(nicknames.get(i).substring(j, j + SUBSTRING_LENGTH));
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
        // forms = list of {이메일, 닉네임}
        List<String> answerList = new ArrayList<>();
        List<String> emails = getEmailsFromForms(forms);
        List<String> nicknames = getNicknamesFromForms(forms);
        Set<String> duplicated = getDuplicatedSubstringSet(nicknames);

        // 해당 닉네임의 substring이 duplicated하면, 해당 유저의 이메일을 answerSet에 추가
        // 문자열 순으로 배열되어야 하므로 TreeSet 사용
        Set<String> answerSet = new TreeSet<>();
        for (int i = 0; i < nicknames.size(); i++) {
            for (int j = 0; j < nicknames.get(i).length() - (SUBSTRING_LENGTH - 1); j++) {
                if (duplicated.contains(nicknames.get(i).substring(j, j + SUBSTRING_LENGTH))) {
                    answerSet.add(emails.get(i));
                }
            }
        }
        for (String a : answerSet) {
            answerList.add(a);
        }
        return answerList;
    }
}
