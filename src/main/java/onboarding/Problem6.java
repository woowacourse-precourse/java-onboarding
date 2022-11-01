package onboarding;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem6 {
    private static final String MESSAGE = "잘못된 입력입니다.";

    public static List<String> solution(List<List<String>> forms) {
        if (!isValidCrewSize(forms)) {
            throw new IllegalArgumentException(MESSAGE);
        }

        List<String> answer = isDuplicate(forms);
        Collections.sort(answer);

        return answer;
    }

    private static List<String> separateNickname(String nickname) {
        Set<String> nicknameParts = new HashSet<>();

        for (int i = 0; i < nickname.length() - 1; i++) {
            String nicknamePart = nickname.substring(i, i + 2);
            nicknameParts.add(nicknamePart);
        }
        return new ArrayList<>(nicknameParts);
    }

    private static List<String> isDuplicate(List<List<String>> forms) {
        Set<String> emailList = new HashSet<>();

        for (int i = 0; i < forms.size() - 1; i++) {
            List<String> nicknameParts = separateNickname(forms.get(i).get(1));
            for (int j = i + 1; j < forms.size(); j++) {
                for (String nicknamePart : nicknameParts) {
                    if ((forms.get(j).get(1).contains(nicknamePart))
                            && isValidNicknameLength(forms.get(i).get(1))
                            && isValidNicknameForm(forms.get(i).get(1))) {
                        addEmail(emailList, forms.get(i).get(0));
                        addEmail(emailList, forms.get(j).get(0));
                    }
                }
            }
        }
        return new ArrayList<>(emailList);
    }

    private static void addEmail(Set<String> emailList, String email) {
        if (isValidEmailLength(email) && isValidEmailForm(email) && isValidEmailDomain(email)) {
            emailList.add(email);
        }
    }

    private static boolean isValidCrewSize(List<List<String>> forms) {
        return forms.size() >= 1 && forms.size() <= 10000;
    }

    private static boolean isValidEmailLength(String email) {
        return email.length() >= 11 && email.length() < 20;
    }

    private static boolean isValidEmailForm(String email) {
        String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private static boolean isValidEmailDomain(String email) {
        int index = email.indexOf('@');
        String form = email.substring(index + 1);
        return form.contains("email.com");
    }

    private static boolean isValidNicknameForm(String nickname) {
        return nickname.matches("^[ㄱ-ㅎㅏ-ㅣ가-힣]*$");
    }

    private static boolean isValidNicknameLength(String nickname) {
        return nickname.length() >= 1 && nickname.length() < 20;
    }
}
