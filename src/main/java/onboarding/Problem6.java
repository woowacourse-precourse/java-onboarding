package onboarding;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem6 {

    public static boolean validation(List<List<String>> forms) {
        int size = forms.size();
        String regexEmail = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@email.com";
        String regexNickname = "^[가-힣]*$";;
        Pattern patternEmail = Pattern.compile(regexEmail);
        Pattern patternNickname = Pattern.compile(regexNickname);
        if (size < 1 || size > 10000) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            String email = forms.get(i).get(0);
            String nickname = forms.get(i).get(1);

            Matcher matcherEmail = patternEmail.matcher(email);
            Matcher matcherNickname = patternNickname.matcher(nickname);
            if (!matcherEmail.matches() || email.length() < 11 || email.length() > 20) {
                return false;
            }
            if (!matcherNickname.matches() || nickname.length() < 1 || nickname.length() > 20){
                return false;
            }
        }
        return true;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        HashSet<String> result = new HashSet<>();

        if (!validation(forms)) {
            return null;
        }

        for (int i = 0; i < forms.size(); i++) {
            String email = forms.get(i).get(0);
            String nickname = forms.get(i).get(1);

            for (int j = 0; j < nickname.length() - 1; j++) {
                String key = nickname.substring(j, j + 2);
                for (int k = i + 1; k < forms.size(); k++) {
                    if (forms.get(k).get(1).contains(key)) {
                        result.add(email);
                        result.add(forms.get(k).get(0));
                    }
                }
            }
        }

        answer.addAll(result);
        answer.sort(Comparator.naturalOrder());

        return answer;
    }
}



