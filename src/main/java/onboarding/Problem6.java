package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> checkMember(List<List<String>> forms, int num, String str, List<String> answer) {
        for(int i = 0; i < forms.size(); i++) {
            if(i != num) {
                String email = forms.get(i).get(0);
                String nickName = forms.get(i).get(1);
                if (nickName.contains(str) && !answer.contains(email)) {
                    answer.add(email);
                }
            }
        }
        return answer;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        for(int i = 0; i < forms.size(); i++) {
            String nickName = forms.get(i).get(1);
            for(int j=2; j <= nickName.length(); j++) {
                for(int k=0; k < nickName.length() - j; k++) {
                    String str = nickName.substring(k, k + j);
                    answer = checkMember(forms, i, str, answer);
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }
}

