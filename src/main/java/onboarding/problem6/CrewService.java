package onboarding.problem6;

import java.util.*;

public class CrewService {
    private static final String EMAIL_DOMAIN = "email.com";
    private static final int NICKNAME_OVERLAP_CKECK_SIZE = 2;

    public List<String> getOverlapCrewEmail(List<List<String>> form) {
        Crews crews = new Crews();
        crews.insert(form);

        return crews.getOverlapCrewsEmail();
    }
}
