package onboarding;

import java.util.*;

public class Problem6 {
    // 기능 1
    public static List<String> getSubString(String str, int len) {
        List<String> ret = new ArrayList<>();

        int limit = str.length() - len;
        for(int i=0;i<=limit;i++) {
            ret.add(str.substring(i, i+len));
        }
        return ret;
    }
    //기능 2
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        Set<String> result = new TreeSet<>();

        for(int i=0;i<forms.size();i++){
            String email = forms.get(i).get(0);
            String nickname = forms.get(i).get(1);
            if(nickname.length() == 1) continue;
            for(int j=2;j<=nickname.length();j++){
                List<String> target = getSubString(nickname, j);
            }
        }

        return answer;
    }
}
