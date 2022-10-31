package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem6 {

    public static void main(String[] args) {
        List<List<String>> forms = List.of(List.of("jm@email.com", "제이엠"),
                                   List.of("jason@email.com", "제이슨"),
                                   List.of("wonie@email.com", "워니"),
                                   List.of("mj@email.com", "엠제이"),
                                   List.of("nowm@email.com", "이제엠"));

        System.out.println(solution(forms));
    }


    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        HashSet<String> emails = new HashSet<>();
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < forms.size(); i++) {
            String name = forms.get(i).get(1);
            if (name.length() < 2) {        //edge case
                break;
            }
            for (int j = 0; j < name.length() - 1; j++) {
                String key = name.substring(j, j + 2);
                if (map.containsKey(key)) {
                    String email = map.get(key);
                    if (!email.equals(forms.get(i).get(0))) {
                        emails.add(email);
                        emails.add(forms.get(i).get(0));
                    }
                }
                map.put(key, forms.get(i).get(0));
            }
        }

        answer = emails.stream().sorted().collect(Collectors.toList());
        return answer;
    }
}
