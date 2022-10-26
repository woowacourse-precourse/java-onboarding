package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    static List<String> answer = new ArrayList<>();

    public static List<String> solution(List<List<String>> forms) {
        for (int i = 0; i < forms.size(); i++) {
            String email = forms.get(i).get(0);
            String nickname = forms.get(i).get(1);

            for(int j = 0; j < nickname.length() - 1; j++) {
                String str = String.valueOf(nickname.charAt(j)) + String.valueOf(nickname.charAt(j + 1));

                boolean isFound = false;
                for (int k = 0; k < forms.size(); k++) {
                    if(k == i) continue;
                    String mail = forms.get(k).get(0);
                    String name = forms.get(k).get(1);
                    isFound = name.contains(str);
                    if(isFound) {
                        if(!answer.contains(mail)) answer.add(mail);
                        if(!answer.contains(email)) answer.add(email);
                        break;
                    }
                    else continue;
                }
                if(isFound) break;
            }
        }

        Collections.sort(answer);

        return answer;
    }
}
