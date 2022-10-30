package onboarding;

import java.util.*;
import java.util.stream.Collectors;


public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        CrewService crewService = new CrewService();
        List<Crew> crewList = forms.stream()
                .map(Crew::new)
                .collect(Collectors.toList());

        crewService.saveAll(crewList);

        return answer;
    }


}

class CrewService {

    private final Map<String, Crew> crewRepository = new HashMap<>();

    public void saveAll(List<Crew> crewList) {
        save(crewList);
    }

    private void save(List<Crew> crewList) {
        crewList.forEach(crew -> crewRepository.put(crew.getEmail(), crew));
    }

}


class Crew {

    private String nickname;
    private String email;

    public Crew(String nickname, String email) {
        this.email = email;
        this.nickname = nickname;

    }

    public Crew(List<String> emailAndNickname) {
        this(emailAndNickname.get(1), emailAndNickname.get(0));
    }

    public String getEmail() {
        return email;
    }

}

