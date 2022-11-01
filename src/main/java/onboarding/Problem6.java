package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        return checkDuplicate(forms, answer);
    }

    public static List<String> checkDuplicate (List<List<String>> forms, List<String> answer) {
        String otherNicknames = "";
        List<String> nicknames = new ArrayList<>();

        for (List<String> form : forms) {
            nicknames.add(form.get(1));
        }

        for (int i = 0; i < nicknames.size(); i++){
            otherNicknames = nicknamesToString(nicknames, i);
            for (String twoUnit : twoUnits(nicknames.get(i))) {
                if (otherNicknames.contains(twoUnit)) {
                    answer.add(forms.get(i).get(0));
                    break;
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }

    public static List<String> twoUnits (String nickname) {
        List<String> twoUnitList = new ArrayList<>();

        for(int i = 0; i<nickname.length()-1; i++){
            if (nickname.length() == 2) twoUnitList.add(nickname);
            else twoUnitList.add(nickname.substring(i,i+2));
        }
        return twoUnitList;
    }

    public static String nicknamesToString (List<String> names, int i) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < names.size(); j++) {
            if (j != i)
                sb.append(names.get(j)).append(".");
        }
        return sb.toString();
    }
}
