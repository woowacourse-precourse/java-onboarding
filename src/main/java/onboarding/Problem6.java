package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class Problem6 {

    private static final int EMAIL = 0;
    private static final int NICKNAME = 1;
    private static final String EMAIL_PATTERN = "\\w+@email.com$";
    private static final String KOREAN_PATTERN = "^[가-힣]+$";

    public static List<String> solution(List<List<String>> forms) {
        if (!isValidate(forms)) {
            return Collections.emptyList();
        }

        String[] nicknames = new String[forms.size()];
        String[] emails = new String[forms.size()];
        getNicknames(forms, nicknames);
        getEmails(forms, emails);

        List<String> answer = getAnswer(nicknames, emails);
        Collections.sort(answer);
        return answer;
    }

    /**
     * 제한사항을 검증하는 기능
     */
    public static boolean isValidate(List<List<String>> forms) {
        for (List<String> form : forms) {
            if (!validateForm(form)) {
                return false;
            }
        }
        return true;
    }

    private static boolean validateForm(List<String> form) {
        int size = form.size();
        String email = form.get(EMAIL);
        String nickname = form.get(NICKNAME);
        return (validateSize(size) && validateEmail(email) && validateNickname(nickname));
    }
    private static boolean validateSize(int size) {
        return (size > 0 && size < 10001);
    }

    private static boolean validateEmail(String email) {
        return (validateEmailLength(email) && validateEmailPrototype(email));
    }

    private static boolean validateEmailLength(String email) {
        return (email != null && email.length() > 10 && email.length() < 20);
    }

    private static boolean validateEmailPrototype(String email) {
        return Pattern.matches(EMAIL_PATTERN, email);
    }

    private static boolean validateNickname(String nickname) {
        return (validateNicknameLength(nickname) && validateLangOfNick(nickname));
    }

    private static boolean validateNicknameLength(String nickname) {
        return (nickname != null && nickname.length() > 0 && nickname.length() < 20);
    }

    private static boolean validateLangOfNick(String nickname) {
        return Pattern.matches(KOREAN_PATTERN, nickname);
    }

    /**
     * 중복된 닉네임이 존재하는 이메일을 저장하는 기능
     */

    public static void getNicknames(List<List<String>> forms, String[] nicknames) {
        int i = 0;
        for (List<String> form : forms) {
            nicknames[i] = form.get(NICKNAME);
            i++;
        }
    }
    public static void getEmails(List<List<String>> forms, String[] emails) {
        int i = 0;
        for (List<String> form : forms) {
            emails[i] = form.get(EMAIL);
            i++;
        }
    }

    public static List<String> getAnswer(String[] nicknames, String[] emails) {
        List<String> answer = new ArrayList<>();
        int idx = 0;
        for (String nickname : nicknames) {
            List<String> result = findDuplicated(nicknames, emails, nickname, idx);
            if (result.size() != 0) {
                answer.removeAll(result);
                answer.addAll(result);
            }
            idx++;
        }
        return answer;
    }

    public static List<String> findDuplicated(String[] nicknames, String[] emails, String nickname, int idx) {
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < nickname.length() - 1; i++) {
            String twoLetters = nickname.substring(i, i + 2);
            for (int j = idx + 1; j < nicknames.length; j++) {
                if (nicknames[j].contains(twoLetters)) {
                    answer.add(emails[i]);
                    answer.add(emails[j]);
                }
            }
        }
        return answer;
    }
}
