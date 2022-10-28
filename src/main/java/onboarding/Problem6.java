package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer;
        Set<String> splitName;
        Set<String> splitNameAll = new HashSet<>();
        Set<String> getDuplicateEmail = new HashSet<>();

        for(List<String> trainee : forms){
            String email = trainee.get(0);
            String name = trainee.get(1);

            splitName = getSplitName(name);

        }

        answer = new ArrayList<>(getDuplicateEmail);
        Collections.sort(answer);
        return answer;
    }

    public static Set<String> getSplitName(String name){
        Set<String> splitWords = new HashSet<>();
        for (int i=0;i<name.length()-1;i++){
            String splitWord = name.substring(i,i+2);
            splitWords.add(splitWord);
        }
        return splitWords;
    }
}
