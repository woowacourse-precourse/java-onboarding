package onboarding.problem6;

import java.util.ArrayList;
import java.util.List;

public class SaveCrew {

    public List<Crew> crewSet(List<List<String>> forms) {

        ArrayList<Crew> crewList = new ArrayList<>();

        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);

            crewList.add(new Crew(email, nickname));
        }
        return crewList;
    }
}
