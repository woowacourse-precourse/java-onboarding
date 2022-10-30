package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        List<String> name = new ArrayList<>(forms.size());

        for (int i = 0; i < name.size(); i++) {
            name.add(i, forms.get(i).get(1));
        }

        for (int i = 0; i < name.size(); i++) {
            for (int j = 0; j < name.size(); j++) {
                if (i == j) {
                    continue;
                }

            }
        }
        return answer;
    }

    static boolean isContain(String str, String other) {
        for (int i = 0; i < str.length()-1; i++) {
            String unit = str.substring(i, i+2);
            if (other.contains(unit)) {
                return true;
            }
        }
        return false;
    }
}
