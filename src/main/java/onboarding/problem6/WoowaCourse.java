package onboarding.problem6;

import java.util.List;
import java.util.stream.Collectors;

public class WoowaCourse {
    private Members members;

    public WoowaCourse(Members members) {
        this.members = members;
    }
    // 유사한 이름을 가진 크루들의 이메일을 반환합니다.
    public List<String> findEmailsAtSimilarUserName() {
        return members.findCrewsAtSimilarUserName()
                      .stream()
                      .sorted()
                      .map(Crew::getEmail)
                      .distinct() // 중복된 이메일이 들어올 것으로 생각하지는 않지만 혹시 모르니....
                      .collect(Collectors.toList());
    }

}
