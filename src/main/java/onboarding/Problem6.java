package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<String> mailList = new ArrayList<>();
        List<List<String>> nameList = new ArrayList<>();


        for (int i = 0; i < forms.size(); i++) {
            String email = forms.get(i).get(0);
            String name = forms.get(i).get(1);
            mailList.add(email);

            String[] stringArr = name.split("");
            List<String> stringList = List.of(stringArr);
            nameList.add(stringList);
        }

        List<List<String>> CombinationListList = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            List<String> split = nameList.get(i);
            List<String> combinationList = new ArrayList<>();
            for (int j = 0; j < split.size() - 1; j++) {
                String combination = split.get(j) + split.get(j + 1);
                combinationList.add(combination);
            }
            CombinationListList.add(combinationList);
        }

        for (int person = 0; person < forms.size(); person++) {
            List<String> flatten = new ArrayList<>();
            List<String> nameCombination = CombinationListList.get(person);
            for (int another = 0; another < forms.size(); another++) {
                if (person == another)
                    continue;
                flatten.addAll(CombinationListList.get(another));
            }
            for (String str : nameCombination) {
                if (flatten.contains(str))
                    answer.add(mailList.get(person));
            }
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
