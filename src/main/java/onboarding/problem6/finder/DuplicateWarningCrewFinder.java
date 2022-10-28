package onboarding.problem6.finder;

import onboarding.problem6.crew.Crew;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateWarningCrewFinder implements CrewFinder{
    @Override
    public List<String> findCrews(List<Crew> crews) {

        return null;
    }

    private Set<String> getNickNameSubset(String nickname){
        if (nickname.length() == 1){
            return new HashSet<>(List.of(nickname));
        }

        Set<String> nickNameSubset = new HashSet<>();
        String[] splitNickname = nickname.split("");
        for (int index = 0; index < splitNickname.length - 1; index++) {
            nickNameSubset.add(splitNickname[index] + splitNickname[index+1]);
        }

        return nickNameSubset;
    }

}
