package onboarding;

import java.util.List;
import onboarding.problem6.CrewFilter;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        CrewFilter crewFilter = CrewFilter.getInstance();

        for (List<String> form : forms) {
            crewFilter.inputForm(form);
        }

        List<String> filteredEmails = crewFilter.filtering();
        crewFilter.clear();

        return filteredEmails;
    }
}
