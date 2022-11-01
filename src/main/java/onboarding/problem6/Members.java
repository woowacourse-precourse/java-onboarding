package onboarding.problem6;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Members {
    public List<Crew> crews;

    public Members(final List<List<String>> forms) {
        this.crews = forms.stream()
                          .map(Crew::new)
                          .collect(Collectors.toList());
    }

    // 이름이 비슷한 크루들을 반환합니다.
    public List<Crew> findCrewsAtSimilarUserName() {
        return crews.stream()
                    .filter(crew -> crew.existsCrewsWithSimilarNamesExceptMe(crews))
                    .collect(toList());
    }
}
