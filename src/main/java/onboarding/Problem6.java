package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        answer = duplicatedCrewEmail(forms);
        return answer;
    }
    private static List<String> duplicatedCrewEmail(List<List<String>> forms) {

        Set<String> e = (Set<String>) duplicatedCrewEmail(forms);
        List<String> emailList = new ArrayList<>(e);

        sortEmailList(emailList);

        return emailList;
    }


}
