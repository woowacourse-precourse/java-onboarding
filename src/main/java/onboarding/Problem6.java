package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

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

    static Boolean isDuplicate(ArrayList<String> splitedNick, ArrayList<String> nick, int idx) {
        Boolean isDup = false;

        for (String nicks : nick) {
            for (String splitedNicks : splitedNick) {
                if (nick.get(idx) == nicks) {
                    break;
                } else if (nicks.contains(splitedNicks)) {
                    System.out.println("nicks: " + nicks);
                    System.out.println("splitedNicks: " + splitedNicks);
                    isDup = true;
                    return isDup;
                }
            }
        }

        return isDup;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        ArrayList<String> email = new ArrayList<>();
        ArrayList<String> nick = new ArrayList<>();

        for (List<String> form : forms) {
            email.add(getEmail(form));
            nick.add(getNick(form));
        }

        for (int i = 0; i < nick.size(); i++) {
            ArrayList<String> splitedNick = splitNick(nick.get(i));
            if (isDuplicate(splitedNick, nick, i)) {
                answer.add(email.get(i));
            }
        }

        Collections.sort(answer);

        return answer;
    }

}
