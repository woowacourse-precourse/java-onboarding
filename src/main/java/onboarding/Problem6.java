package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Problem6 {

    public static boolean nicknameSimilarityCheck(String nickname1, String nickname2) {
        for (int i = 0; i < nickname1.length() - 1; i++) {
            String substring1 = nickname1.substring(i, i + 2);
            for (int j = 0; j < nickname2.length() - 1; j++) {
                String substring2 = nickname2.substring(j, j + 2);
                if (substring1.equals(substring2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static List<String> solution(List<List<String>> forms) {
        Set<String> similar = new TreeSet<>();

        for (int i = 0; i < forms.size() - 1; i++) {
            for (int j = i + 1; j < forms.size(); j++) {
                List<String> form1 = forms.get(i);
                List<String> form2 = forms.get(j);
                if (nicknameSimilarityCheck(form1.get(1), form2.get(1))) {
                    similar.add(form1.get(0));
                    similar.add(form2.get(0));
                }
            }
        }

        List<String> answer = new ArrayList<>(similar);

        return answer;
    }
}
