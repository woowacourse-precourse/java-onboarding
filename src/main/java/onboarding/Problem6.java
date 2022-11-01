package onboarding;

import problem6.Crews;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Crews crews = new Crews(forms);
        return crews.filterDuplicateCrew();
    }
}
