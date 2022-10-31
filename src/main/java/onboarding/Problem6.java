package onboarding;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        Set<String> answerSet = new HashSet<>();
        int nsLength = forms.size();
        for(int i = 0; i < nsLength - 1; i++){
            int nLength = forms.get(i).get(1).length();
            for(int j = 0; j < nLength - 1; j++){
                String str = forms.get(i).get(1).substring(j, j+2);
                for(int k = i + 1; k < nsLength; k++){
                    if(forms.get(k).get(1).contains(str)) {
                        answerSet.add(forms.get(i).get(1));
                        answerSet.add(forms.get(k).get(1));
                    }
                }
            }
        }
        for(String s : answerSet){
            answer.add(s);
        }
        return answer;
    }
}
