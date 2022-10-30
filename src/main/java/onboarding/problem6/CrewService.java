package onboarding.problem6;

import java.util.*;

public class CrewService {
    private static final String EMAIL_DOMAIN = "email.com";
    private static final int NICKNAME_OVERLAP_CKECK_SIZE = 2;

    public List<String> getOverlapCrewEmail(List<List<String>> form) {
        List<Crew> crews =  mapToClews(form);
        List<String> overlapClews = getOverlapClewsEmail(crews);
        Collections.sort(overlapClews);

        return overlapClews;
    }

    private List<Crew> mapToClews(List<List<String>> form) {
        List<Crew> crews = new ArrayList<>();
        form.forEach(list -> {
            Crew crew = new Crew(list.get(0), list.get(1));
            Optional<Crew> overlapClew = searchOverlapCrew(crews, crew);
            overlapClew.ifPresent(c -> crew.overlap());
            crews.add(crew);
        });

        return crews;
    }

    private Optional<Crew> searchOverlapCrew(List<Crew> crews, Crew crew) {
        return crews.stream()
                .filter(c -> isOverlapNickname(crew.getNickname(), c.getNickname()))
                .peek(Crew::overlap)
                .findFirst();
    }

    private List<String> getOverlapClewsEmail(List<Crew> crews) {
        List<String> result = new ArrayList<>();
        for(Crew c : crews) {
            if(c.isOverlap()) {
                result.add(c.getEmail());
            }
        }

        return result;
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
