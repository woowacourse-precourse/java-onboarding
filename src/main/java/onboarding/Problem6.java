package onboarding;

import java.util.Comparator;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new java.util.ArrayList<>();

        // 신청할 수 있는 이메일은 email.com 도메인으로만 제한한다.
        for(List<String> K:forms){
            if(!K.get(0).endsWith("email.com")){
                forms.remove(K);
            }
        }

        for(List<String> L: forms.subList(0,forms.size()-1)){
            for(int j = 0; j < L.get(1).length()-1;j++){
                for(List<String> M: forms.subList(forms.indexOf(L)+1, forms.size())){
                    if(M.get(1).contains(L.get(1).substring(j, j+2))){
                        if(!answer.contains(M.get(0))){
                            answer.add(M.get(0));
                        }
                        if(!answer.contains(L.get(0))){
                            answer.add(L.get(0));
                        }
                    }
                }
            }
        }
        answer.sort(Comparator.naturalOrder());
        return answer;
    }
}
