package onboarding;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Collections;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        Set<Integer> indexset = new HashSet<>();

        for(int i=0; i<forms.size(); i++){
            for(int j=0; j<forms.get(i).get(1).length()-1; j++){
                for(int k=i+1; k<forms.size(); k++){
                    for(int l=0; l<forms.get(k).get(1).length()-1; l++){
                        if(forms.get(i).get(1).substring(j, j+2).equals(forms.get(k).get(1).substring(l, l+2))){
                            indexset.add(i);
                            indexset.add(k);
                            break;
                    }
                    }
                }

            }
        }
        for(int i : indexset){
            answer.add(forms.get(i).get(0));
        }
        Collections.sort(answer);
        return answer;
    }
}
