package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        // List<String> answer = List.of("answer");
        List<String> answer = new ArrayList<>();
        String subString = "";

        for (int i=0; i<forms.size(); i++) {
            String name = forms.get(i).get(1);
            String email = forms.get(i).get(0);

            if (!email.contains("@email.com")) continue;   // 이메일 형식에 부합하고 해당 도메인을 가지지 않으면 넘어간다.

            for (int j=0; j<name.length() - 1; j++) {
                subString = "" + name.charAt(j) + name.charAt(j+1);

                for (int k=i+1; k<forms.size(); k++) {
                    if (forms.get(k).get(1).contains(subString) && !answer.contains(forms.get(k).get(0))) {
                        answer.add(forms.get(k).get(0));
                    }
                }
            }
        }



        return answer;
    }
}
