package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = result(forms);
        return answer;
    }

    public static List<String> result(List<List<String>> forms) {
        Set<String> result = new HashSet<>();
        int numberOfCrew = forms.size();

        for (int i = 0; i < numberOfCrew - 1; i++) {
            List<String> crew1 = forms.get(i);
            for (int j = i + 1; j < numberOfCrew; j++) {
                List<String> crew2 = forms.get(j);
                if (haveDuplicate(crew1, crew2)) {
                    result.add(crew1.get(0));
                    result.add(crew2.get(0));
                }
            }
        }
        return List.copyOf(result);
    }

    public static boolean haveDuplicate(List<String> crew1, List<String> crew2) {
        String crew1Nick = crew1.get(1);
        String crew2Nick = crew2.get(1);
        for (int i = 0; i < crew1Nick.length() - 1; i++) {
            for (int j = 0; j < crew2Nick.length() - 1; j++) {
                if (crew1Nick.substring(i, i+2).equals(crew2Nick.substring(j, j+2)))
                    return true;
            }
        }
        return false;
    }


}
