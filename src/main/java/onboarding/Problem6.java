package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        /**
         * 1번부터 forms.size()-2까지의 닉네임을통해
         * 닉네임의 1,2번째 글자, 2,3번째 글자순으로 확인하면서
         * 나보다 순서가 느린 닉네임들에 들어있는지 확인하는 방법으로 구현
         */
        for(int i=0; i<forms.size(); i++){
            String name = forms.get(i).get(1);
            for(int j=0; j<name.length()-1; j++){
                String tmp = name.substring(j,j+2);
                for(int k=i+1; k<forms.size(); k++){
                    String tmp2 = forms.get(k).get(1);
                    if(tmp2.contains(tmp)) {
                        answer.add(forms.get(k).get(0));
                        answer.add(forms.get(i).get(0));
                    }
                }
            }
        }
        Set<String> set = new HashSet<String>(answer);
        List<String> ans = new ArrayList<String>(set);
        Collections.sort(ans);
        return ans;
    }
}

