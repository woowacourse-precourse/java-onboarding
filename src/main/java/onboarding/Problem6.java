package onboarding;

import onboarding.problem6.Main;
import onboarding.problem6.collection.Crews;
import onboarding.problem6.domain.Crew;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Main main = new Main();
        Crews crews = main.makeCollectionCrews(forms);
        List<Crew> crewListOfOverlappingNickname = crews.getCrewListWithOverlappingNickname();
        return main.getAscendingEmailListFrom(crewListOfOverlappingNickname);
    }
}
