package onboarding;

import java.util.*;

public class Problem6 {
    public static void main(String[] args) {
        List<List<String>> forms = List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        );
        solution(forms);
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        String[] arrayEmail = new String[forms.size()];
        String[] arrayName = new String[forms.size()];

        // 배열로 이메일, 이름 따로 분류
        for (int i = 0; i < forms.size(); i++) {
            for (int j = 0; j < forms.get(i).size(); j++) {
                arrayEmail[i] = forms.get(i).get(0);
                arrayName[i] = forms.get(i).get(1);
            }
        }

        // 이름마다 두 글자씩 분리
        for (int i = 0; i < arrayName.length; i++) {
            String name = arrayName[i];
            for (int j = 0, x = 2; j < name.length() - 1; j++) {
                String namePart = name.substring(j, x++);
                System.out.println(namePart);
            }

        }

        System.out.println(Arrays.toString(arrayEmail));
        System.out.println(Arrays.toString(arrayName));

        return answer;
    }

}
