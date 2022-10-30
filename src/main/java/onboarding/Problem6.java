package onboarding;


import onboarding.problem6.Crew;
import onboarding.problem6.CrewService;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {

        CrewService crewService = new CrewService();

        List<Crew> crewList = forms.stream()
                .map(Crew::new)
                .collect(Collectors.toList());
        crewService.saveAll(crewList);

        List<Crew> duplicateCrewList = crewService.findDuplicateCrewList();

        return duplicateCrewList.stream()
                .map(Crew::getEmail)
                .sorted()
                .collect(Collectors.toList());
    }


}
