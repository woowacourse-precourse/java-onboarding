package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> updateDuplicateMember(int memberNum, String subStr, List<List<String>> forms, List<String> answer) {
        for(int m = 0; m < forms.size(); m++) {
            if(m == memberNum) continue;
            String email = forms.get(m).get(0);
            String nickName = forms.get(m).get(1);
            if(nickName.contains(subStr) && !answer.contains(email)) {
                answer.add(email);
            }
        }
        return answer;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        for(int m = 0; m < forms.size(); m++) {
            String nickName = forms.get(m).get(1);
            for(int i=2; i <= nickName.length(); i++) {
                for(int j=0; j < nickName.length() - i; j++) {
                    String subStr = nickName.substring(j, j + i);
                    answer = updateDuplicateMember(m, subStr, forms, answer);
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }
}
