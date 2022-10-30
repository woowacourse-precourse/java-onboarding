package onboarding;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        List<Set<String>> conv = new ArrayList<Set<String>>();
        Set<Integer> ans = new HashSet<Integer>();
        List<String> email = new ArrayList<String>();

        int num = 0;


        for (List<String> ls : forms) {
            String name = ls.get(1);
            Set<String> set = new HashSet<String>();
            for (int i = 0; i < name.length() - 1; i++) {
                String two = name.substring(i, i + 2);
                set.add(two);
            }
            conv.add(set);
            num++;
        }

        for (int i = 0; i < num - 1; i++) {
            for (int j = i+1; j < num; j++) {
                Set comp = conv.get(j);
                comp.retainAll(conv.get(i));
                if (!comp.isEmpty()) {
                    ans.add(i);
                    ans.add(j);
                }
            }
        }

        for (int e : ans) {
            email.add(forms.get(e).get(0));
        }

        Collections.sort(email);

        answer = email;

        return answer;
    }
}
