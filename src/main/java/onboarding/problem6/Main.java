package onboarding.problem6;

import onboarding.problem6.collection.Crews;
import onboarding.problem6.domain.Crew;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public Crew makeCrewByEmailAndNickname(String email, String nickname) {
        return new Crew(email, nickname);
    }

    public Crews makeCollectionCrews(List<List<String>> forms) {
        List<Crew> crewList = new ArrayList<>();
        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);
            Crew crew = makeCrewByEmailAndNickname(email, nickname);
            crewList.add(crew);
        }
        Crews crews = new Crews(crewList);
        return crews;
    }
}
