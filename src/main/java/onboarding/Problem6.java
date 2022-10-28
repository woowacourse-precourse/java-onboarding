package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer;
        Set<String> getDuplicateEmail = new HashSet<>();
        Map<String, Set<String>> allTraineeSplitNames = new HashMap<>();

        getAllSplitNames(forms, allTraineeSplitNames);

        for(List<String> trainee : forms){
            String email = trainee.get(0);
            if(isDuplicate(trainee, allTraineeSplitNames)){
                getDuplicateEmail.add(email);
            }
        }
        answer = new ArrayList<>(getDuplicateEmail);
        Collections.sort(answer);
        return answer;
    }

    public static boolean isDuplicate(List<String> trainee, Map<String, Set<String>> allTraineeSplitNames){
        String email = trainee.get(0);
        String name = trainee.get(1);

        Set<String> allTraineeEmail = allTraineeSplitNames.keySet();
        for(String traineeEmail : allTraineeEmail){
            if(email.equals(traineeEmail)) continue;
            Set<String> splitName = allTraineeSplitNames.get(traineeEmail);
            for(String word : splitName){
                if(name.contains(word)) return true;
            }
        }
        return false;
    }

    public static void getAllSplitNames(List<List<String>> forms, Map<String, Set<String>> allTraineeSplitNames){
        for(List<String> trainee : forms){
            String email = trainee.get(0);
            String name = trainee.get(1);

            allTraineeSplitNames.put(email, getSplitName(name));
        }
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
