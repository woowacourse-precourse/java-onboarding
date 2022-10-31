package onboarding;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        HashSet<String> emails = new HashSet<>();
        Map<String, String > hashMap = new HashMap<>();

        for(int i = 0; i<forms.size(); i++) {
            String name = forms.get(i).get(1);

            if (name.length() < 2 || name.length() > 19) {
                break;
            }
        }

        List<String> answer = List.of("answer");

        return answer;
    }
}


