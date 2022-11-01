package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> a = new HashSet<>();

        for (int i = 0; i < forms.size(); i++) {
            String name = forms.get(i).get(1);

            if (name.length() > 1) {
                for (int j = 0; j < name.length() - 1; j++) {
                    String s = name.substring(j, j + 2);
                    for (List<String> form : forms) {
                        if (form.get(1).contains(s) && !(name.equals(form.get(1)))) {
                            a.add(form.get(0));
                        }
                    }

                }
            }
        }
        return new ArrayList<>(a);
    }
}
