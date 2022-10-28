package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = getWrongNameList(forms);
        Collections.sort(answer);

        return answer;
    }

    public static List<String> getWrongNameList(List<List<String>> forms){
        Map<String, String> userMap = new HashMap<>();
        Set<String> wrongNameSet = new HashSet<>();
        List<String> wrongNameList;
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
                    userMap.put(partedWord, email);
            }
        }

        wrongNameList = new ArrayList<>(wrongNameSet);
        return wrongNameList;
    }
}
