package onboarding;

import java.util.ArrayList;
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
            
        }
    }
}
