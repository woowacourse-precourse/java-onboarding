package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>();
        int size = forms.size();
        for(int i=0;i<size;i++){
            String name = forms.get(i).get(1);
            for(int j=0;j<name.length()-1;j++){
                String cat = name.substring(j,j+2);
                int overlap = 0;
                for(int k=i+1;k<size;k++){
                    if(forms.get(k).get(1).contains(cat)){
                        String email = forms.get(k).get(0);
                        if(!answer.contains(email)) answer.add(email);
                        overlap += 1;
                    }
                }
                if(overlap > 0){
                    String email = forms.get(i).get(0);
                    if(!answer.contains(email)) answer.add(email);
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }
}
