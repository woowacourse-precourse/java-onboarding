package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        List<String> answer = new ArrayList<>();
        for(int i=0;i<forms.size();i++){
            List<String> stringUnit = new ArrayList<>();
            int nickNameLength = forms.get(i).get(1).length();
            String email = forms.get(i).get(0);
            String nickName = forms.get(i).get(1);
            for(int n =0;n<nickNameLength-1;n++){
                for(int m=n;m<nickNameLength;m++){
                    String nickNameSubString = nickName.substring(n,m+1);
                    if(nickNameSubString.length()>=2){
                        stringUnit.add(nickNameSubString);
                    }
                }
            }
            boolean checkOverlap =false;
            for(int j=0;j<forms.size();j++){
                String otherNickName = forms.get(j).get(1);
                if(i==j){
                    continue;
                }
                for(int n=0;n<stringUnit.size();n++){
                    if(otherNickName.contains(stringUnit.get(n))){
                        checkOverlap =true;
                        break;
                    }
                }
            }
            if(checkOverlap){
                answer.add(email);
            }
        }
        Collections.sort(answer);
        return answer;
    }
}
