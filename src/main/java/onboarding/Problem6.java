package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> email = new ArrayList<String>();
        List<String> nickName = new ArrayList<String>();
        for (int i = 0; i < forms.size(); i++) {
            email.add(forms.get(i).get(0));
            nickName.add(forms.get(i).get(1));
        }
        System.out.println(email);
        System.out.println(nickName);
        for (int i = 0; i < forms.size() - 1; i++) {
            for (int j = i + 1; j < forms.size(); j++) {
                if (nickName.get(i));
            }
        }


        List<String> answer = List.of("answer");

        return answer;
    }
}
