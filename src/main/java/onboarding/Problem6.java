package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<String> result = new ArrayList<>();
        HashMap<String, Integer> name = new HashMap<>();

        for (int i = 0; i < forms.size(); i++) {
            for (int j = 0; j < forms.get(i).get(1).length() - 1; j++) {
                String subName = forms.get(i).get(1).substring(j, j + 2);
                if (!name.containsKey(subName)) {
                    name.put(subName, i);
                }
            }
        }
    }
}
