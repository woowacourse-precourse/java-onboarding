package onboarding;

import java.util.*;

public class Problem6 {

    private static final int EMAIL = 0;
    private static final int NICKNAME = 1;

    public static List<String> solution(List<List<String>> forms) {

        Set<String> resultSet = new HashSet<>();

        for (List<String> initForm : forms) {
            String nickname = getListValue(initForm, NICKNAME);
            if (nickname.length() > 1) {
                findEmailsWithDuplicateNickname(forms, resultSet, nickname);
            }
        }
        return sortList(resultSet);
    }

    public static void findEmailsWithDuplicateNickname(List<List<String>> forms, Set<String> resultSet, String nickname) {
        for (int i = 0; i < nickname.length() - 1; i++) {
            String nickSub = nickname.substring(i, i + 2);
            for (List<String> form : forms) {
                if (isContainsSubString(nickSub, form) && isNotSameOwnName(nickname, form)) {
                    addEmailToResult(resultSet, form);
                }
            }
        }
    }

    private static boolean addEmailToResult(Set<String> resultSet, List<String> form) {
        return resultSet.add(getListValue(form, EMAIL));
    }

    private static boolean isContainsSubString(String nickSub, List<String> form) {
        return getListValue(form, NICKNAME).contains(nickSub);
    }

    private static boolean isNotSameOwnName(String nickname, List<String> form) {
        return !getListValue(form, NICKNAME).equals(nickname);
    }

    private static String getListValue(List<String> form, int nicknameIndexNum) {
        return form.get(nicknameIndexNum);
    }

    private static List<String> sortList(Set<String> a) {
        List<String> answer = new ArrayList<>(a);
        answer.sort(Comparator.naturalOrder());
        return answer;
    }
}
