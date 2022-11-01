package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<String> combinationsOfName = new ArrayList<>();
        Map<String, String> crewInformationMap = new HashMap<>();

        for(List<String> crew : forms) {
            crewInformationMap.put(crew.get(1), crew.get(0));
            makeCombinationsOfName(combinationsOfName, crew.get(1));
        }
        for(String combination : combinationsOfName){
            List<String>tmpList = crewInformationMap.entrySet()
                    .stream()
                    .filter(key -> key.getKey().contains(combination) )
                    .map(Map.Entry::getValue)
                    .collect(Collectors.toList());
            if(tmpList.size() > 1) {
                answer.addAll(tmpList);
            }
        }
        answer.sort(Comparator.naturalOrder());
        return answer;
    }

    public static void makeCombinationsOfName(List<String> combinations, String name){
        List<String> separatedName = new ArrayList<>(Arrays.asList(name.split("")));
        for(int i = 0; i < name.length() - 1; i++){
            String partOfName = separatedName.get(i) + separatedName.get(i+1);
            if(!combinations.contains(partOfName)) combinations.add(partOfName);
        }
    }
}
