package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        for(int i=0;i<forms.size();i++){
            String form=forms.get(i).get(1);
            for (int j = i + 1; j < forms.size(); j++) {
                String compare=forms.get(j).get(1);

                for(int k=1;k<form.length();k++) {
                    String find=form.substring(k-1,k+1);
                    if(compare.contains(find)){
                        if(i==0)answer.add(forms.get(i).get(0));
                        answer.add(forms.get(j).get(0));
                        break;
                    }


                }
            }
        }
        answer=answer.stream().distinct().collect(Collectors.toList());
        Collections.sort(answer);
        return answer;
    }
}
