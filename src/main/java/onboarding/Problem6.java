package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class Problem6 {

    private static List<String> getOverlapUser(String name, List<List<String>> forms) {
        List<String> result = new ArrayList<>();

        for (int start = 0; start < name.length() - 1; start++) {
            for (int len = 2; start + len <= name.length(); len++) {
                String subName = name.substring(start, start + len);
                for (List<String> form : forms) {
                    if (form.get(1).indexOf(subName) != -1) {
                        result.add(form.get(0));
                    }
                }
            }
        }
        return (result);
    }

    public static List<String> solution(List<List<String>> forms) {
        HashMap<String, String> emails = new HashMap<>();

        for (int i = 0; i < forms.size(); i++) {
            List<String> overlapUser = getOverlapUser(forms.get(i).get(1), forms.subList(i + 1, forms.size()));
            if (overlapUser.size() > 0) {
                emails.put(forms.get(i).get(0), "");
            }
            for (String user : overlapUser) {
                emails.put(user, "");
            }
        }

        List<String> answer = new ArrayList<>(emails.keySet());
        Collections.sort(answer);

        return answer;
    }
}
