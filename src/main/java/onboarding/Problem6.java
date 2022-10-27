package onboarding;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        HashSet<String> dupList = new HashSet<>();

        for (int i = 0; i < forms.size(); i++) {
            for (int j = i + 1; j < forms.size(); j++) {

                String target_name = forms.get(i).get(1);
                String compare_name = forms.get(j).get(1);

                String target_email = forms.get(i).get(0);
                String compare_email = forms.get(j).get(0);

                if (isDuplicate(target_name, compare_name)) {
                    dupList.add(target_email);
                    dupList.add(compare_email);
                    continue;
                }
            }
        }

        List<String> answer = dupList.stream().collect(Collectors.toList());
        Collections.sort(answer);

        return answer;
    }

    private static boolean isDuplicate(String target, String compare) {

        for (int s = 0; s < target.length() - 1; s++) {
            String sliced = target.substring(s, s + 2);

            if (compare.indexOf(sliced) > -1) {
                return true;
            }
        }

        return false;
    }

}
