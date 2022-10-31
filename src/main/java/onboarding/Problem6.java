package onboarding;

import onboarding.problem6.crew.Crew;
import onboarding.problem6.crew.WooaCrew;
import onboarding.problem6.finder.CrewFinder;
import onboarding.problem6.finder.DuplicateWarningCrewFinder;
import onboarding.problem6.crew.validator.CrewValidator;
import onboarding.problem6.crew.validator.CrewValidatorV1;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        CrewValidator validator = new CrewValidatorV1();
        List<Crew> crews = new ArrayList<>();
        CrewFinder finder = new DuplicateWarningCrewFinder();

        for(List<String> data : forms){
            crews.add(new WooaCrew(data, validator));
        }

        return finder.findCrews(crews);
    }
}
