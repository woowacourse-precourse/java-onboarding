package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        ArrayList<String> answer = new ArrayList<>();
        HashMap<String, Integer> nameCount = new HashMap<>();

        for (int i = 0; i < forms.size(); i += 1) {
            for (int j = 0; j < forms.get(i).get(1).length() - 1; j += 1) {
                String slicedName = forms.get(i).get(1).substring(j, j + 2);

            }
        }

        return answer;
    }
}