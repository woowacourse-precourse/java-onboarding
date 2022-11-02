package onboarding;

import problem6.Crew;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Crew crew = new Crew(forms);
        List<String> answer = crew.findDuplicateUser();
        return answer;
    }
}
