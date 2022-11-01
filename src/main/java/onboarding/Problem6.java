package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

public class Problem6 {
    public static void constraintCheck(List<List<String>> forms) throws Exception {
        String emailRegExp = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@email\\.com$";
        String nicknameRegExp = "^[가-힣]{1,19}$";

        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);

            if (!Pattern.matches(emailRegExp, email) || email.length() < 11 || email.length() >= 20) {
                throw new Exception("invalid email format.");
            }
            if (!Pattern.matches(nicknameRegExp, nickname)) {
                throw new Exception("invalid nickname format.");
            }
        }
    }

    public static boolean isOverlap(String name1, String name2) {
        for (int i = 0; i < name1.length() - 1; i++) {
            String substr = name1.substring(i, i + 2);
            if (name2.contains(substr)) {
                return true;
            }
        }
        return false;
    }

    public static List<String> solution(List<List<String>> forms) {
        try {
            constraintCheck(forms);
        } catch (Exception e) {
            e.printStackTrace();
        }

        HashSet<String> emails = new HashSet<>();

        for (int i = 0; i < forms.size() - 1; i++) {
            for (int j = i + 1; j < forms.size(); j++) {
                List<String> crew1 = forms.get(i);
                List<String> crew2 = forms.get(j);

                if (isOverlap(crew1.get(1), crew2.get(1))) {
                    emails.add(crew1.get(0));
                    emails.add(crew2.get(0));
                }
            }
        }
        ArrayList<String> result = new ArrayList<>(emails);
        Collections.sort(result);
        return result;
    }
}
