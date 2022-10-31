package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<String, String> info = new HashMap<>();
        String email = "";
        String name = "";

        // 매개변수로 들어온 forms를 HashMap으로 변환
        for (int i = 0; i < forms.size(); i++) {
            for (int j = 0; j < forms.get(i).size(); j++)
                email = forms.get(i).get(0);
                name = forms.get(i).get(1);
                info.put(email, name);
        }


        return answer;
    }


}
