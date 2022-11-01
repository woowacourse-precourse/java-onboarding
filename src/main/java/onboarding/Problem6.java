package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<Crew> crewList = new ArrayList<>();
        Map<String, Integer> sequenceWordMap = new HashMap<>();

        for (List<String> crewInfo : forms) {
            String email = crewInfo.get(0);
            String crewName = crewInfo.get(1);
            Crew crew = new Crew(crewName, email);
            crewList.add(crew);

            addCrewName(sequenceWordMap, crewName);
        }

        for (Crew crew : crewList) {
            Optional<String> email = findEmail(sequenceWordMap, crew);

            email.ifPresent(answer::add);
        }

        Collections.sort(answer);

        return answer;
    }

    private static Optional<String> findEmail(Map<String, Integer> sequenceWordMap,
        Crew crew) {
        String crewName = crew.getName();

        for (int i = 0; i < crewName.length() - 1; i++) {
            String substring = crewName.substring(i, i + 2);

            if (sequenceWordMap.get(substring) > 1) {
                return Optional.ofNullable(crew.getEmail());
            }
        }
        return Optional.empty();
    }
    
    private static void addCrewName(Map<String, Integer> sequenceWordMap, String crewName) {
        for (int i = 0; i < crewName.length() - 1; i++) {
            String substring = crewName.substring(i, i + 2);

            if (sequenceWordMap.containsKey(substring)) {
                sequenceWordMap.put(substring, sequenceWordMap.get(substring) + 1);
            } else {
                sequenceWordMap.put(substring, 1);
            }
        }
    }
}

class Crew {

    private String name;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Crew(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
