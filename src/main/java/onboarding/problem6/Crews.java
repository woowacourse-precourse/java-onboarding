package onboarding.problem6;

import java.util.List;

public class Crews {

    private final List<Crew> crews;

    public Crews(List<Crew> crews) {
        assertDistinctEmails(crews);
        validateCrewsRange(crews);

        this.crews = crews;
    }

    public List<Crew> getCrews() {
        return crews;
    }

    private void assertDistinctEmails(List<Crew> crews) throws IllegalArgumentException {
        if (crews.size() != crews.stream().map(Crew::getEmail)
                .distinct().count()) {
            throw new IllegalArgumentException("crews의 모든 Crew의 email은 중복되지 말아야 합니다.");
        }
    }

    private void validateCrewsRange(List<Crew> crews) throws IllegalArgumentException {
        if (!(1<=crews.size() && crews.size()<=10000)) {
            throw new IllegalArgumentException("crews의 크기는 1이상 10,000이하여야 합니다.");
        }
    }
}
