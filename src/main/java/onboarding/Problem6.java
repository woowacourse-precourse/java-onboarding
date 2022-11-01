package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> nameHashedSet = new ArrayList<>();
        HashSet<String> nameDuplicated = new HashSet<>();
        List<String> answer = new ArrayList<>();

        //get all possible name set
        for(int j = 0; j < forms.size(); j++){
            String ch[] = forms.get(j).get(1).split("");
            for(int l = 0; l < ch.length; l++){
                if(l != ch.length-1){
                    String combined = ch[l] + ch[l+1];
                    //get used name set
                    if(nameHashedSet.contains(combined)){
                        nameDuplicated.add(combined);
                    }
                    nameHashedSet.add(combined);
                }
            }
        }

        //if the set is duplicated, add
        for(int k = 0; k < forms.size(); k++){
            for(String name: nameDuplicated){
                if(forms.get(k).get(1).contains(name)){
                    answer.add(forms.get(k).get(0));
                }
            }
        }

        //sort the set
        answer.sort(Comparator.naturalOrder());

        return answer;
    }
}
