package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        String compare = "";
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < forms.size(); i++) {
            String email = forms.get(i).get(0);
            String nickname = forms.get(i).get(1);
            for (int j = 0; j < forms.size(); j++) {
                if (nickname.equals(forms.get(j).get(1))) {
                    continue;
                }
                String s = "";
                for(int k=0; k<forms.get(j).get(1).length()-1; k++) {
                    s += forms.get(j).get(1).charAt(k);
                    s += forms.get(j).get(1).charAt(k+1);
                    if(nickname.contains(s)){
                        map.put(email, "");
                        map.put(forms.get(j).get(0), "");
                    }
                }
            }
        }
        answer = new ArrayList<>(map.keySet());
        Collections.sort(answer);
        return answer;
    }
}
