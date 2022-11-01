package onboarding;

import java.util.List;

public class Problem6 {

    static String getEmail(List<List<String>> forms, int i) {

        List<String> formOne = forms.get(i);
        String email = formOne.get(0);

        return email;
    }

    static String getNick(List<List<String>> forms, int i) {

        List<String> formOne = forms.get(i);
        String nick = formOne.get(1);

        return nick;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        for (int i = 0; i < forms.size(); i++) {
            String email = getEmail(forms, i);
        }

        return answer;
    }

}
