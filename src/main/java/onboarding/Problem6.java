package onboarding;

import java.util.LinkedList;
import java.util.List;

public class Problem6 {

    public static boolean validate_nick(String user, String validate) {

        for (int i = 0; i < user.length(); i++) {
            for (int  j = i + 2; j < user.length(); j++) {
                String subString = user.substring(i, j);
                if (validate.contains(subString))
                    return true;
            }
        }

        return false;
    }

    public static boolean validate_email(String email, List<String> answer) {
        return !answer.contains(email);
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new LinkedList<>();
        for(int i = 0 ; i < forms.size(); i++) {
            String user_email = forms.get(i).get(0);
            String user_nick = forms.get(i).get(1);

            for(int j = i + 1; j < forms.size(); j++) {
                String validator_email = forms.get(j).get(0);
                String validator_nick = forms.get(j).get(1);

                if (validate_nick(user_nick, validator_nick)) {
                    if (validate_email(user_email, answer))
                        answer.add(user_email);
                    if (validate_email(validator_email, answer))
                        answer.add(validator_email);

                }
            }
        }
        answer.sort(String::compareTo);
        return answer;
    }
}
