package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> answer = new HashSet<>();

        Set[] set = new HashSet[forms.size()];

        for(int i = 0; i < forms.size(); i++){
            set[i] = new HashSet();

            String nickname = forms.get(i).get(1);
            for(int j = 2; j <= nickname.length(); j++){
                set[i].add(nickname.substring(j-2, j));
            }
        }

        for(int i = 0; i < set.length; i++){
            for(int j = i+1; j < set.length; j++){
                Set<String> tempSet = new HashSet<>();

                tempSet.addAll(set[i]);
                tempSet.addAll(set[j]);

                if(tempSet.size()!= set[i].size()+set[j].size()){
                    answer.add(forms.get(i).get(0));
                    answer.add(forms.get(j).get(0));
                }
            }
        }

        return answer.stream().sorted().collect(Collectors.toList());
    }
}
