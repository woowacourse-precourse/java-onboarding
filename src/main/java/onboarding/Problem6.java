package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        for(int i=0;i< forms.size()-1;i++){
            for(int k=0;k<forms.get(i).get(1).length()-1;k++){
                String str = String.valueOf(forms.get(i).get(1).charAt(k))+ forms.get(i).get(1).charAt(k+1);
                for(int j=i+1;j<forms.size()-1;j++){
                    if(forms.get(j).get(1).contains(str)){
                        answer.add(forms.get(i).get(0));
                        answer.add(forms.get(j).get(0));
                    }
                }
            }
        }
        return answer;
    }
}
