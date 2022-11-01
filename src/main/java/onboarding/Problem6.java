package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    static boolean isOverlap(String nickname1, String nickname2) {
        List<String> listChar = new ArrayList<String>();
        for (int i = 0; i < nickname1.length() - 1; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(nickname1.charAt(i));
            sb.append(nickname1.charAt(i + 1));
            listChar.add(sb.toString());
        }
        for (String ch : listChar) {
            if (nickname2.contains(ch)) {
                return true;
            }
        }
        return false;
    }


    public static List<String> solution(List<List<String>> forms) {
        HashSet<String> setEmails = new HashSet<>();
        for (int i = 0; i < forms.size(); i++) {
            for (int j = i + 1; j < forms.size(); j++) {
                List<String> info1 = forms.get(i);
                List<String> info2 = forms.get(j);
                if (isOverlap(info1.get(1), info2.get(1))) {
                    setEmails.add(info1.get(0));
                    setEmails.add(info2.get(0));
                }
            }
        }
    }
}
