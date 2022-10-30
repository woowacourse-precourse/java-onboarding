package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        for(int i = 0; i < forms.size() - 1; i++){
            for(int j = i + 1; j < forms.size(); j++){
                List<String> crew1 = forms.get(i);
                List<String> crew2 = forms.get(j);

                String crew1_mail = crew1.get(0);
                String crew1_name = crew1.get(1);

                String crew2_mail = crew2.get(0);
                String crew2_name = crew2.get(1);
            }
        }

        return answer;
    }
}
