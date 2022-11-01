package onboarding.problem6;

import onboarding.problem6.exception.CrewFormOutOfSizeException;
import onboarding.problem6.exception.CrewMemberOutOfSizeException;

import java.util.*;

public class Crews {
    private static final int MIN_CREW_COUNT = 1;
    private static final int MAX_CREW_COUNT = 1_000;
    private static final int CREW_FORM_ELEMENT_COUNT = 2;
    private final List<Crew> crews = new ArrayList<>();

    public void insert(List<List<String>> form) {
        validateCrewCount(form.size());
        form.forEach(list -> {
            validateFormFormat(list);
            Crew crew = new Crew(list.get(0), list.get(1));
            Optional<Crew> overlapClew = searchOverlapCrew(crew);
            overlapClew.ifPresent(c -> crew.overlap());
            crews.add(crew);
        });
    }

    private void validateFormFormat(List<String> form) {
        if(form.size() != CREW_FORM_ELEMENT_COUNT) {
            throw new CrewFormOutOfSizeException();
        }

    }

    private void validateCrewCount(int crewCount) {
        if(crewCount < MIN_CREW_COUNT || crewCount > MAX_CREW_COUNT) {
            throw new CrewMemberOutOfSizeException();
        }
    }

    public List<String> getOverlapCrewsEmail() {
        List<String> result = new ArrayList<>();
        for(Crew c : crews) {
            if(c.isOverlap()) {
                result.add(c.getEmail());
            }
        }
        Collections.sort(result);

        return result;
    }

    private Optional<Crew> searchOverlapCrew(Crew crew) {
        return crews.stream()
                .filter(c -> isOverlapNickname(crew.getNickname(), c.getNickname()))
                .peek(Crew::overlap)
                .findFirst();
    }

    private boolean isOverlapNickname(String nickname1, String nickname2) {
        Set<String> overlapCheckSet = getOverlapCheckSet(nickname1, nickname2);
        int totalSplitCount = getTotalSplitCount(nickname1, nickname2);

        return overlapCheckSet.size() != totalSplitCount;
    }

    private int getTotalSplitCount(String ...str) {
        int count = 0;
        for(String s : str) {
            count += s.length() -1;
        }

        return count;
    }

    private Set<String> getOverlapCheckSet(String ...nickname) {
        Set<String> result = new HashSet<>();
        for(String s : nickname) {
            putSplitNickname(result, s);
        }

        return result;
    }
    private void putSplitNickname(Set<String> set, String nickname) {
        for (int i = 0; i < nickname.length()-1; i++) {
            String substring = nickname.substring(i, i + 2);
            set.add(substring);
        }
    }
}
