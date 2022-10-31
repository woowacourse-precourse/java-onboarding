package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<String> mailList = new ArrayList<>();
        List<List<String>> nameList = new ArrayList<>();

        String email;
        String name;


        for (int i = 0; i < forms.size(); i++) {
            email=forms.get(i).get(0);
            mailList.add(email);
            name = forms.get(i).get(1);

            String[] stringArr = name.split("");
            List<String> stringList = List.of(stringArr);
            nameList.add(stringList);
        }





        return answer;
    }

    public static void main(String args[]) {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );
        System.out.println(Problem6.solution(forms));
    }
}
