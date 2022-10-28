package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String, String> userMap = new HashMap<>();
        Set<String> wrongNameSet = new HashSet<>();
        List<String> answer;
        String name;
        String email;
        String partedWord;

        for(List<String> list : forms){
            email = list.get(0);
            name = list.get(1);
            for(int i=0; i<name.length()-1; i++){
                partedWord = name.substring(i, i+2);
                if(userMap.containsKey(partedWord)){
                    wrongNameSet.add(email);
                    wrongNameSet.add(userMap.get(partedWord));
                }else
                    map.put(partedWord, email);
            }
        }

        answer = new ArrayList<>(wrongNameSet);
        Collections.sort(answer);

        return answer;
    }
}
