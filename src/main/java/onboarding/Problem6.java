package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        HashMap<String, Integer> nameMap = getNameMap(forms);
        return null;
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
}
