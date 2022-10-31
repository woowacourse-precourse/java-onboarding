package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        String nickname = null;
        String email = null;

        for(int j = 0; j < forms.size(); j++){
            int checkWordLen = 2;

            nickname = forms.get(j).get(1);
            email = forms.get(j).get(0);

            while(checkWordLen <= nickname.length()) {

                List<String> tmpEmail = new ArrayList<>();
                tmpEmail.add(email);
                for (int k = j + 1; k < forms.size(); k++) {

                    for (int i = 0; i+checkWordLen -1 < nickname.length() && checkWordLen < forms.get(k).get(1).length(); i+=1) {

                        if (forms.get(k).get(1).contains(nickname.substring(i, i + checkWordLen))) {
                            tmpEmail.add(forms.get(k).get(0));
                        }
                    }
                }

                if(tmpEmail.size() >= 2) {
                    for (String em : tmpEmail) {
                        if (!answer.contains(em)){
                            answer.add(em);
                        }
                    }
                }
                checkWordLen+=1;
            }

        }
        Collections.sort(answer);
        return answer;
    }
}
