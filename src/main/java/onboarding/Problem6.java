package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        //List<String> answer = List.of("answer");
        List<String> answer = new ArrayList<>();

        for(int i=0; i<forms.size(); i++){
            boolean flag = false;
            String nickname = forms.get(i).get(1);

            for(int j = 1; j< nickname.length(); j++){
                String subName = nickname.substring(j-1, j+1);
                for(int k = i+1; k<forms.size(); k++){
                    if(forms.get(k).get(1).contains(subName)){
                        flag = true;
                        String email = forms.get(k).get(0);
                        if(!answer.contains(email))
                            answer.add(email);
                    }
                }
            }

            if(flag == true && !answer.contains(forms.get(i).get(0))){
                answer.add(forms.get(i).get(0));
            }

        }
        Collections.sort(answer);

        return answer;
    }
}
