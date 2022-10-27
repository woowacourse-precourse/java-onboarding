package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    final static int EMAIL = 0;
    final static int NAME = 1;
    public static List<String> solution(List<List<String>> forms) {
        HashMap<String, String> contacts = new HashMap<>();
        for (int i=0; i<forms.size(); i++) {
            List<String> form = forms.get(i);
            contacts.put(form.get(EMAIL),form.get(NAME));
        }

        List<String> answer = List.of("answer");
        return answer;
    }
}
