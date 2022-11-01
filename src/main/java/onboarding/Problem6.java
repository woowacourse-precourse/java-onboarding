package onboarding;

import java.util.HashSet;
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

    static HashSet<String> splitNick(String nick) {
        HashSet<String> splitedNick = new HashSet<>();
        for (int i = 0; i < nick.length()-1; i++) {
            String casesNick = nick.substring(i, i+2);
            splitedNick.add(casesNick);
        }
        return splitedNick;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        for (int i = 0; i < forms.size(); i++) {
            String email = getEmail(forms, i);
            String nick = getNick(forms, i);
        }

        return answer;
    }

}
