package problem6;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Crews {

    private final List<Crew> crews;

    public Crews(List<List<String>> inputCrews) {
        crews = new ArrayList<>();
        inputCrews.stream().map(Crew::new).forEach(crews::add);
    }

    public List<String> filterDuplicateCrew() {
        Set<Crew> result = new HashSet<>();

        IntStream.range(0, crews.size()).forEach(crewIdx -> {
            Crew crew = crews.get(crewIdx);
            Set<Crew> duplicateCrews = checkDuplicateOtherCrews(crewIdx, crew);

            result.addAll(duplicateCrews);
        });
        return mapToString(result);
    }

    private Set<Crew> checkDuplicateOtherCrews(int crewIdx, Crew crew) {
        Set<Crew> result = IntStream.range(crewIdx + 1, crews.size())
                .mapToObj(crews::get)
                .filter(crew::isDuplicateNickname)
                .collect(Collectors.toSet());

        if (!result.isEmpty()) {
            result.add(crew);
        }
        return result;
    }

    private List<String> mapToString(Set<Crew> result) {
        return result.stream()
                .map(crew -> crew.toResultResponseDto().getEmail())
                .sorted()
                .collect(Collectors.toList());
    }
}
