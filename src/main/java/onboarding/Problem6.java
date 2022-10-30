package onboarding;


import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        CrewService crewService = new CrewService();

        List<Crew> crewList = forms.stream()
                .map(Crew::new)
                .collect(Collectors.toList());
        crewService.saveAll(crewList);

        List<Crew> duplicateCrewList = crewService.findDuplicateCrewList();

        return duplicateCrewList.stream()
                .map(Crew::getEmail)
                .sorted()
                .collect(Collectors.toList());
    }


}

class CrewService {

    private final Map<String, Crew> crewRepository = new HashMap<>();
    private final Map<String, Integer> usingNicknameRepository = new HashMap<>();

    public void saveAll(List<Crew> crewList) {
        crewList.forEach(crew -> crewRepository.put(crew.getEmail(), crew));
        crewList.forEach(this::saveSplitNickname);
        crewList.forEach(this::countUsingNickname);
    }

    private void saveSplitNickname(Crew crew) {
        for (int i = 0; i < crew.getNickname().length() - 1; i++) {
            String splitNickname = crew.getNickname().substring(i, i + 2);
            usingNicknameRepository.put(splitNickname, 0);
        }
    }

    private void countUsingNickname(Crew crew) {
        for (String usingNickname : usingNicknameRepository.keySet()) {
            if (crew.getNickname().contains(usingNickname)) {
                usingNicknameRepository.put(usingNickname, usingNicknameRepository.getOrDefault(usingNickname, 0) + 1);
            }
        }
    }

    public List<Crew> findDuplicateCrewList() {
        Set<Crew> duplicateCrewList = new HashSet<>();

        usingNicknameRepository.keySet().stream()
                .filter(use -> usingNicknameRepository.get(use) > 1)
                .forEach(usingNickname -> {
                    crewRepository.values().stream()
                            .filter(crew -> crew.getNickname().contains(usingNickname))
                            .forEach(duplicateCrewList::add);
                });

        return new ArrayList<>(duplicateCrewList);
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

    public String getNickname() {
        return nickname;
    }
}

