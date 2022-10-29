package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
            for (int j = 0; j < forms.size(); j++) {
                if (i != j) {
                    String firstNick = forms.get(i).get(1);
                    String secNick = forms.get(j).get(1);

                    checkNick(forms, answer, i, j, firstNick, secNick);
                }
            }
        }
        return answer;
    }

    private static void checkNick(List<List<String>> forms, List<String> answer, int i, int j, String firstNick, String secNick) {
        if (firstNick.length() <= 19 && Pattern.matches("^[가-힣]*$", firstNick)
                && secNick.length() <= 19 && Pattern.matches("^[가-힣]*$", secNick)) {

            for (int k = 0; k < firstNick.length() - 1; k++) {
                String substringOfFirstNick = firstNick.substring(k, k + 2);

                if (secNick.indexOf(substringOfFirstNick) != -1) {
                    String firstEmail = forms.get(i).get(0);
                    String secEmail = forms.get(j).get(0);

                    addEmails(forms, answer, i, j, firstEmail, secEmail);
                }
            }
        }
    }

    private static void addEmails(List<List<String>> forms, List<String> answer, int i, int j, String firstEmail, String secEmail) {
        if (!answer.contains(firstEmail) && firstEmail.contains("@email.com")
                && firstEmail.length() >= 11 && firstEmail.length() <= 19) {
            answer.add(forms.get(i).get(0));
        }
        if (!answer.contains(secEmail) && secEmail.contains("@email.com")
                && secEmail.length() >= 11 && secEmail.length() <= 19) {
            answer.add(forms.get(j).get(0));
        }
    }
}
