package onboarding.problem6;

import onboarding.problem6.domain.Crew;

public class Main {
    public Crew makeCrewByEmailAndNickname(String email, String nickname) {
        return new Crew(email, nickname);
    }
}
