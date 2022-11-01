package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<Integer> divideName(List<List<String>> forms){
        List<Integer> idx = new ArrayList<>(); 

        for (int i = 0; i < forms.size(); i++) {
            String first = forms.get(i).get(1);
            if (first.length() == 1){
                continue;
            }
            for (int j = i+1; j < forms.size(); j++) {
                String second = forms.get(j).get(1);
                if (second.length() == 1){
                    continue;
                }
                for (int k = 0; k <= first.length() - 2; k++) {
                    for (int l = 0; l <= second.length() - 2; l++) {
                        if(first.substring(k, k+2).equals(second.substring(l, l+2))){
                            idx.add(i);
                            idx.add(j);
                        }
                    }
                }                
            }

        }
        return idx;
    }


    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>(List.of());
        List<Integer> index = divideName(forms);

        List<Integer> notDuplicationIndex = index.stream()
                .distinct()
                .collect(Collectors.toList());

        for (Integer integer : notDuplicationIndex) {
            answer.add(forms.get(integer).get(0));
        }

        Collections.sort(answer);

        return answer;
    }
}
