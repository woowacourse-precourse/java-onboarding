package onboarding.problem6;

import java.util.List;

public class Crew implements Comparable<Crew> {
    private final Email            email;
    private final ConsecutiveNames consecutiveNames;
    private final String           name;


    public Crew(String email, String name) {
        this.email            = new Email(email);
        this.consecutiveNames = new ConsecutiveNames(name);
        this.name             = name;
    }

    public Crew(List<String> input) {
        this(input.get(0), input.get(1));
    }

    // 나를 제외한 다른 크루들이 비슷한 이름을 가진 사람이 있습니까?
    public boolean existsCrewsWithSimilarNamesExceptMe(final List<Crew> crews) {
        for (Crew crew : crews) {
            // 자신은 자신을 제외하고 유사한 이름을 가진 사람이 있는지 검사합니다.
            if (this.isSimilarName(crew)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSimilarName(Crew crew) {
        //자신과는 비교하지 않습니다.
        if (this == crew) {
            return false;
        }
        return this.consecutiveNames.isSimilar(crew.consecutiveNames);
    }


    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int compareTo(Crew o) {
        return this.email.compareTo(o.email) ;
    }

    public String getEmail() {
        return email.email();
    }
}
