package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Problem6 {

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
            email.add(form.get(0));
            nick.add(form.get(1));
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
