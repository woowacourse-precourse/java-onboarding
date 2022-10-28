package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer;
        Set<String> getDuplicateEmail = new HashSet<>();
        Map<Integer, Set<String>> allTraineeSplitNames = new HashMap<>();

        getAllSplitNames(forms, allTraineeSplitNames);

        for(int traineeId=0; traineeId<forms.size(); traineeId++){
            List<String> trainee = forms.get(traineeId);
            String email = trainee.get(0);
            if(isDuplicate(traineeId, trainee, allTraineeSplitNames)){
                getDuplicateEmail.add(email);
            }
        }
        answer = new ArrayList<>(getDuplicateEmail);
        Collections.sort(answer);
        return answer;
    }

    public static boolean isDuplicate(int traineeId, List<String> trainee, Map<Integer, Set<String>> allTraineeSplitNames){
        String name = trainee.get(1);

        Set<Integer> allTraineeIdx = allTraineeSplitNames.keySet();
        for(Integer traineeIdx : allTraineeIdx){
            if(traineeId == traineeIdx) continue;
            Set<String> splitName = allTraineeSplitNames.get(traineeIdx);
            for(String word : splitName){
                if(name.contains(word)) return true;
            }
        }
        return false;
    }

    public static void getAllSplitNames(List<List<String>> forms, Map<Integer, Set<String>> allTraineeSplitNames){
        for(int traineeId=0; traineeId<forms.size(); traineeId++){
            String name = forms.get(traineeId).get(1);

            allTraineeSplitNames.put(traineeId, getSplitName(name));
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
