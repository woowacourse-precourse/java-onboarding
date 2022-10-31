package onboarding;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Problem6 {
    public static List<String> delDuplicate(List<String> emails){
        ArrayList<String> deleted = new ArrayList<String>();

        if(emails.size() >= 2) {
            for (String email : emails) {
                if (!deleted.contains(email)){
                    deleted.add(email);
                }
            }
        }

        return deleted;
    }

    public static List<List<String>> isAvailable(List<List<String>> forms){
        List<List<String>> available = new ArrayList<List<String>>();

        for (int i = 0; i < forms.size(); i ++){
            String email = forms.get(i).get(0);
            String nickname = forms.get(i).get(1);
            String emailregex = "^[a-zA-Z0-9]{1,9}@email[.]com$";
            String nameregex = "^[ㄱ-ㅎㅏ-ㅣ가-힣]{1,19}$";

            if (email.length() > 10 && email.length() < 20 && Pattern.matches(emailregex, email) && Pattern.matches(nameregex, nickname)) {
                available.add(forms.get(i));
            }
        }
        return available;
    }

    public static List<String> checkDuplication(List<List<String>> forms, List<String> target) {
        List<String> result = new ArrayList<String>();
        String email = target.get(0);
        String nickname = target.get(1);
        int len = 2;

        while (len <= nickname.length()) {
            for (List<String> form : forms) {
                for (int i = 0; i < nickname.length() - len + 1; i++) {
                    String part = nickname.substring(i, i + len);
                    if (form.get(1).contains(part)) {
                        result.add(form.get(0));
                    }
                }
            }
            len ++;
        }

        if (result.size() > 0){
            result.add(email);
        }

        return result;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>();

        if (forms.size() > 10_000) {
            return answer;
        }

        forms = isAvailable(forms);

        for (int i = 0; i < forms.size(); i++) {
            List<String> form = forms.get(i);
            List<String> result = checkDuplication(forms.subList(i + 1, forms.size()), form);
            answer.addAll(result);
        }

        answer = delDuplicate(answer);
        Collections.sort(answer);
        return answer;
    }
}
