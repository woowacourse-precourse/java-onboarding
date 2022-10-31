package onboarding;

import java.util.*;

public class Problem6 {
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
        List<String> answer = new ArrayList<>();

        Set<String> result = new TreeSet<>();

        for(int i=0;i<forms.size();i++){
            String email = forms.get(i).get(0);
            String nickname = forms.get(i).get(1);
            if(nickname.length() == 1) continue;
            int count = 0;
            for(int j=2;j<=nickname.length();j++){
                List<String> target = getSubString(nickname, j);
                for(int k=i+1;k<forms.size();k++){
                    String tmp = forms.get(k).get(1);
                    for(String sub : target) {
                        if(tmp.contains(sub)) {
                            result.add(forms.get(k).get(0));
                            count += 1;
                        }
                    }
                }
            }
            if(count > 0) result.add(email);
        }
        for(String elem : result) answer.add(elem);
        return answer;
    }
}
