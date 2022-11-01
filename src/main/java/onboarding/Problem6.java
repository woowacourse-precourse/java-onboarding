package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        Set<String> answerSet = new HashSet<>();
        HashMap<String, String> emailNickName = new HashMap<>();

        for(int i=0; i<forms.size(); i++){
            String curNickName = forms.get(i).get(1);
            String curEmail = forms.get(i).get(0);
            for(int j=0; j<curNickName.length()-1; j++){
                String splitNickName = curNickName.substring(j,j+2);
                if(emailNickName.isEmpty()){
                    emailNickName.put(splitNickName,curEmail);
                }
                else if(emailNickName.containsKey(splitNickName)&&!curEmail.equals(emailNickName.get(splitNickName))){
                    answerSet.add(curEmail);
                    answerSet.add(emailNickName.get(splitNickName));
                }
            }
        }
        List<String> answer = new ArrayList<>(answerSet);
        return answer;
    }
}
