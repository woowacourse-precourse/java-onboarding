package onboarding;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        ArrayList<String> answer = new ArrayList<>();
        Set<Integer> overlapIndexSet = new HashSet<>();
        HashMap<String,Integer> twoNameMap = new HashMap<>();
        for(int formIndex=0; formIndex < forms.size(); formIndex++) {
            setTwoName(overlapIndexSet, formIndex, forms, twoNameMap);
        }
        List<Integer> overlapIndexList = new ArrayList<>(overlapIndexSet);
        for(int i=0; i < overlapIndexList.size(); i++){
            answer.add(forms.get(overlapIndexList.get(i)).get(0));
        }
        Collections.sort(answer);
        return answer;
    }
    private static void setTwoName(Set overlapIndexSet, int formIndex, List<List<String>> forms, HashMap<String, Integer> twoNameMap) {
        String name = forms.get(formIndex).get(1);
        for (int i = 0; i < name.length() - 1; i++) {
            String twoName = name.charAt(i) + Character.toString(name.charAt(i + 1));
            if (twoNameMap.containsKey(twoName)) {
                overlapIndexSet.add(twoNameMap.get(twoName));
                overlapIndexSet.add(formIndex);
            } else {
                twoNameMap.put(twoName, i);
            }
        }
    }
}
