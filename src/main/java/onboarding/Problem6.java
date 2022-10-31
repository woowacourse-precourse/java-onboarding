package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        if (forms.size() == 1) {
            return Collections.emptyList();
        }

        Set<String> set = new TreeSet<>();
        for (int i = 0; i < forms.size() - 1; i++) {
            String nickName = forms.get(i).get(1);
        }
        return new ArrayList<>(set);
    }
}
