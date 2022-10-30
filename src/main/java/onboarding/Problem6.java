package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        Set<String> draft = new HashSet<>();

        for(int i=0; i<forms.size(); i++){
            String nickName = forms.get(i).get(1);
            String frag = "";
            for(int j=0; j<nickName.length()-1; j++){
                frag = nickName.substring(j, j+2);
                    for(int k=i+1; k<forms.size(); k++){
                        if(forms.get(k).get(1).contains(frag)){
                            draft.add(forms.get(i).get(0));
                            draft.add(forms.get(k).get(0));
                        }
                    }
            }
        }
        List<String> answer = new ArrayList<>(draft);
        Collections.sort(answer);
        return answer;
    }
}