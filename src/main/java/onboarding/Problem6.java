package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {

    public static List<String> getName(List<List<String>> forms) {
        List<String> name = new ArrayList<>();
        for (List<String> form : forms) {
            name.add(form.get(1));
        }
        return name;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<String> name = getName(forms);

        return answer;
    }
}
