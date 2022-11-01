package onboarding;
import java.util.*;
public class Problem6 {
    public static HashMap<String, Set<Integer>> hashMap = new HashMap<>();
    
    public static Set<Integer> duplicateIdx = new HashSet<>();
    
    public static void addDuplicateCrews(){
    	
        for (String s : hashMap.keySet()) {
            if (hashMap.get(s).size() >= 2){
                for (Integer crewIdx : hashMap.get(s)) {
                    duplicateIdx.add(crewIdx);
                }
            }
        }
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++){
            String name = forms.get(i).get(1);
            if (name.length() == 1) continue;
            for (int j = 0; j < name.length() - 1; j++){
                String currPart = name.substring(j, j + 2);
                hashMap.computeIfAbsent(currPart, s -> new HashSet<>());
                hashMap.get(currPart).add(i);
            }
        }
        addDuplicateCrews();

        for (Integer idx : duplicateIdx) {
            answer.add(forms.get(idx).get(0));
        }
        Collections.sort(answer);

        return answer;
    }
}