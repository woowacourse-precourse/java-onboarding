package onboarding;

import java.util.*;

public class Problem6 {

    public static boolean isValidDomain(String email) {
        String pattern = "([a-zA-z0-9]+)(@email.com)";

        if (email.matches(pattern)) {
            return true;
        }
        return false;
    }


    public static String getSubNickname(String nickname, int idx) {
        return nickname.substring(idx, idx+2);
    }

    public static String getMail(String mail) {
        if (!isValidDomain(mail)) {
            return null;
        }

        int atIdx = mail.indexOf('@');
        String mailId = mail.substring(0, atIdx);

        return mailId;
    }

    public static boolean isDuplicate(List<String> userForm, List<String> otherForm) {
        String userMail = userForm.get(0);
        String userNickname = userForm.get(1);
        String otherMail = otherForm.get(0);
        String otherNickname = otherForm.get(1);

        if (userMail == null || otherMail == null) { // 유효하지 않은 도메인은 체크하지 않음
            return false;
        }

        if (otherMail.equals(userMail)) {
            return false;
        }

        for (int i = 0; i < userNickname.length() - 1; i++) {
            String subNickname = getSubNickname(userNickname, i);
            if (otherNickname.contains(subNickname)) {
                return true;
            }
        }
        return false;
    }

    public static HashSet<String> getDupUserMail(List<String> userForm, List<List<String>> forms) {
        HashSet<String> dupUserMailSet = new HashSet<>();

        for (List<String> form: forms) {
            if (isDuplicate(userForm, form)) {
                String dupUserMail = form.get(0);

                dupUserMailSet.add(dupUserMail);
            }
        }
        return dupUserMailSet;
    }

    public static List<String> getSortedList(HashSet<String> dupResult) {
        List<String> dupUserList = new ArrayList<>(dupResult);
        Collections.sort(dupUserList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return getMail(o1).compareTo(getMail(o2));
            }
        });

        return dupUserList;
    }

    public static List<String> getDupResult(List<List<String>> forms) {
        HashSet<String> dupResult = new HashSet<>();

        for (List<String> form: forms) {
            HashSet<String> dupUserMailSet = getDupUserMail(form, forms);

            dupResult.addAll(dupUserMailSet);
        }

        List<String> dupUserList = getSortedList(dupResult);

        return dupUserList;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        answer = getDupResult(forms);

        return answer;
    }
}
