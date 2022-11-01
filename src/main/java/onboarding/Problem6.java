package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
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

    static ArrayList<String> splitNick(String nick) {
        ArrayList<String> splitedNick = new ArrayList<>();
        for (int i = 0; i < nick.length() - 1; i++) {
            String casesNick = nick.substring(i, i+2);
            splitedNick.add(casesNick);
        }
        return splitedNick;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        HashSet<String> splited = new HashSet<>();

        for (int i = 0; i < forms.size(); i++) {
            String email = getEmail(forms, i);
            String nick = getNick(forms, i);
        }

        return answer;
    }

}
