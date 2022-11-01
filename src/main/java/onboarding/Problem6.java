package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        HashMap<String, Integer> nameMap = getNameMap(forms);
        return getEmail(nameMap, forms);
    }
    public static HashMap<String, Integer> getNameMap(List<List<String>> forms){
        HashMap<String, Integer> nameMap = new HashMap<>();
        for (List<String> form : forms){
            String name = form.get(1);
            for (int i = 0 ; i < name.length() - 1 ; i++){
                String subsetOfName = name.substring(i, i + 2);
                if (nameMap.containsKey(subsetOfName))
                    nameMap.put(subsetOfName, nameMap.get(subsetOfName) + 1);
                else {
                    nameMap.put(subsetOfName, 1);
                }
            }
        }
        return nameMap;
    }

    public static List<String> getEmail(HashMap<String, Integer> nameMap, List<List<String>> forms){
        List<String> answer = new ArrayList<>();
        for (List<String> form : forms){
            HashMap<String, Integer> eachNameMap = new HashMap<>();
            String name = form.get(1);
            String email = form.get(0);
            for (int i = 0 ; i < name.length() - 1 ; i++){
                String subsetOfName = name.substring(i, i + 2);
                if (eachNameMap.containsKey(subsetOfName))
                    eachNameMap.put(subsetOfName, eachNameMap.get(subsetOfName) + 1);
                else {
                    eachNameMap.put(subsetOfName, 1);
                }
            }
            for (String subsetName : eachNameMap.keySet()){
                if (nameMap.get(subsetName) > eachNameMap.get(subsetName)){
                    answer.add(email);
                    break;
                }
            }
        }
        Collections.sort(answer, Comparator.comparing(s -> s.split("@")[0]));
        return answer;
    }
}
