package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

public class Problem6 {
    private static final int EMAIL = 0;
    private static final int NICKNAME = 1;
    private static final String EMAIL_FORM = "[0-9a-zA-Z]+(.[_a-z0-9-]+)*@email.com$";
    private static final String KOREAN_ALPHABET = "^[ㄱ-ㅎ가-힣]*$";
    public static List<String> solution(List<List<String>> forms) {
        if (!verifyException(forms)) {
            return List.of("Error");
        }

        HashSet<String> hashSet = new HashSet<String>(); // 중복 제거를 위해 HashSet 사용
        for (List<String> form : forms) {
            String name = form.get(NICKNAME);
            for (int i = 0; i < name.length(); i++) {
                if (i + 1 < name.length()) {
                    String pickChars = name.substring(i, i + 2);
                    String otherEmail = null;
                    if ((otherEmail = isDuplicate(forms, forms.indexOf(form) + 1, pickChars)) != null) {
                        hashSet.add(form.get(EMAIL));
                        hashSet.add(otherEmail);
                    }
                }
            }
        }

        return hashToList(hashSet);
    }

    private static String isDuplicate(List<List<String>> forms, int index, String pickChars) {
        for (int i = index; i < forms.size(); i++) {
            String name = forms.get(i).get(NICKNAME);
            if (name.contains(pickChars)) {
                return forms.get(i).get(EMAIL);
            }
        }
        return null;
    }

    private static List<String> hashToList(HashSet<String> hashSet) {
        List<String> answer = new ArrayList<String>(hashSet);

        Collections.sort(answer);
        return answer;
    }

    private static boolean verifyException(List<List<String>> forms) {
        for (List<String> form : forms) {
            if (!checkSizeCrew(form)) {
                return false;
            }
            if (!checkEmail(form.get(EMAIL)) || !checkNickname(form.get(NICKNAME))) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkSizeCrew(List<String> form) {
        return (form.size() >= 1 && form.size() <= 10000);
    }

    private static boolean checkEmail(String email) {
        return (isValidLength(email) && isValidEmail(email));
    }

    private static boolean isValidLength(String email) {
        return (email.length() >= 11 && email.length() < 20);
    }

    private static boolean isValidEmail(String email) {
        return (Pattern.matches(EMAIL_FORM, email));
    }

    private static boolean checkNickname(String nickname) {
        return (Pattern.matches(KOREAN_ALPHABET, nickname));
    }

}
