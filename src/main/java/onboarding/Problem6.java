package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem6 {
    static List<String> emails;
    public static List<String> solution(List<List<String>> forms) {
        emails = new ArrayList<>();

        for(int i = 0; i < forms.size() - 1; i++) {
            distinguishEmail(i, forms);
        }
        emails.sort(Comparator.naturalOrder());

        return emails;
    }

    public static void distinguishEmail(int i, List<List<String>> forms) {
        List<String> form = forms.get(i);

        String email1 = form.get(0);
        String name1 = form.get(1);

        for(int j = i+1; j<forms.size(); j++) {
            List<String> compareWithForm = forms.get(j);

            String email2 = compareWithForm.get(0);
            String name2 = compareWithForm.get(1);

            if(name1.length() < 2) continue;

            List<String> names = List.of(name1, name2);
            List<String> email = List.of(email1, email2);
            addEmails(names, email);
        }
    }
    public static void addEmails(List<String> names, List<String> email) {
        if(isDuplicated(names.get(0), names.get(1))) {
            containEmail(email);
        }
    }
    public static boolean isDuplicated(String name1, String name2) {
        for(int i = 0; i < name1.length() - 1; i++) {
            String tmp = name1.substring(i, i+2);
            if(name2.contains(tmp)) return true;
        }
        return false;
    }
    public static void containEmail(List<String> email) {
        for (String e : email) {
            if(!emails.contains(e)) {
                emails.add(e);
            }
        }
    }


}
