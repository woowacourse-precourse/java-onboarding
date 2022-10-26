package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    static class CheckList {
        int [] checkName;

        public CheckList(List<Integer> forms) {
            checkName = new int[forms.size()];
            for(int i = 0; i < forms.size(); i++)
                checkName[i] = 0;
        }
        void checkingList(List<List<String>> forms) {
            String compName = forms.get(0).get(1);
        }
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");


        return answer;
    }

    public static void main(String[] args) {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );
//        System.out.println(forms.get(0).get(1));
        solution(forms);
    }
}
