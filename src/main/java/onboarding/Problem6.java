package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        ArrayList<String> answer = new ArrayList<>();

        throwCrewNumberException(forms);

        return answer;
    }

    public static boolean throwCrewNumberException(List<List<String>> forms) {

        return forms.isEmpty() || forms.size() > 10_000;
    }
}
