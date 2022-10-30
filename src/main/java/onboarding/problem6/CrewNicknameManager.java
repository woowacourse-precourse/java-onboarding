package onboarding.problem6;

import java.util.*;
import java.util.stream.Collectors;

public class CrewNicknameManager {

    private Set<Crew> crewSet;
    private Map<String, Crew> nicknameSubstringMap;
    private Set<Crew> nicknamePartiallyDuplicatedCrewSet;

    public CrewNicknameManager(List<List<String>> forms){
        initializeMemberList(forms);
    }

    private void initializeMemberList(List<List<String>> forms){
        crewSet = new HashSet<>();
        for (List<String> form : forms){
            crewSet.add(new Crew(form));
        }
    }

    public List<String> findEmailOfCrewsPartiallyDuplicateNickname(){
        setNicknamePartiallyDuplicatedCrewSet();
        return StringList.sort(getEmailOfNicknamePartiallyDuplicatedCrews());
    }

    private void setNicknamePartiallyDuplicatedCrewSet(){
        nicknamePartiallyDuplicatedCrewSet = new HashSet<>();
        nicknameSubstringMap = new HashMap<>();

        Map<String, Crew> subStringMap = new HashMap<>();
        for (Crew crew : crewSet){
            String nickname = crew.getNickname();
            addSubstringMapAndIdentifyNicknamePartiallyDuplicated(crew);
        }
    }

    private void addSubstringMapAndIdentifyNicknamePartiallyDuplicated(Crew crew){
        String nickname = crew.getNickname();
        for (int i=0; i<nickname.length() -1; i++){
            String substringOfNickname = nickname.substring(i, i+2);

            if (isIncludeInNicknameSubstringMap(substringOfNickname)){
                nicknamePartiallyDuplicatedCrewSet.add(crew);
                nicknamePartiallyDuplicatedCrewSet.add(nicknameSubstringMap.get(substringOfNickname));
            } else {
                nicknameSubstringMap.put(substringOfNickname, crew);
            }
        }
    }

    private boolean isIncludeInNicknameSubstringMap(String substring){
        return nicknameSubstringMap.containsKey(substring);
    }

    private List<String> getEmailOfNicknamePartiallyDuplicatedCrews(){
        return nicknamePartiallyDuplicatedCrewSet.stream()
                .map(crew -> crew.getEmail())
                .collect(Collectors.toList());
    }


}
