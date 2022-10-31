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

        for (Map.Entry<String, Integer> e : name.entrySet()) {
            int temp = e.getValue();
            String str = e.getKey();

            for (int j = 0; j < forms.size(); j++) {
                if (temp == j) {
                    continue;
                }
                boolean check = false;

                for (int k = 0; k < forms.get(j).get(1).length() - 1; k++) {
                    String subName = forms.get(j).get(1).substring(k, k + 2);

                    if (str.equals(subName)) {
                        result.add(forms.get(j).get(0));
                        check = true;
                        break;
                    }
                }

                if (check && !result.contains(forms.get(temp).get(0))) {
                    result.add(forms.get(temp).get(0));
                }
            }
        }

    }
}
