package onboarding.problem6;

import java.util.ArrayList;
import java.util.List;

public class SaveCrewMember {

    public List<CrewMember> crewMeberSet(List<List<String>> forms) {

        ArrayList<CrewMember> crewMeberList = new ArrayList<>();

        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);

            crewMeberList.add(new CrewMember(email, nickname));
        }
        return crewMeberList;
    }
}
