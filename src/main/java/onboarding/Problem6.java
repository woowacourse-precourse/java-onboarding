package onboarding;

import java.util.*;

/**
 * 문제 풀이 방식 & 기능 목록서는
 * docs/PROBLEM6.md 의 하단에 기술되어 있습니다
 */
public class Problem6 {
    static List<String> nameList;
    public static List<String> solution(List<List<String>> forms) {
        nameList = new ArrayList<>();
        Set<String> overlapSet = findOverlapCrew(forms);
        return sortSet(overlapSet);
    }


    private static List<String> sortSet(Set<String> overlapSet) {
        List<String> overlapList = new ArrayList<>(overlapSet);
        Collections.sort(overlapList);
        return overlapList;
    }

    private static Set<String> findOverlapCrew(List<List<String>> forms){
        HashMap<String, String> map = new HashMap<>();
        Set<String> overlapSet = new HashSet<>();
        OuterLoop:
        for(List<String> form : forms){
            String crewEmail = form.get(0);
            String crewName = form.get(1);
            for(String name: nameList){
                if(impossibleName(crewName, name)){
                    overlapSet.add(crewEmail);
                    overlapSet.add(map.get(name));
                    continue OuterLoop;
                }
            }
            map.put(crewName, crewEmail);
            nameList.add(crewName);
        }
        return overlapSet;

    }

    private static boolean impossibleName(String crewName, String name) {
        for(int i =0; i< crewName.length()-1; i++){
            String subStr = crewName.substring(i, i+2);
            if(name.contains(subStr)){
                return true;
            }
        }
        return false;
    }
}
