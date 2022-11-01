package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> getCase(String name) {
        List<String> cases = new ArrayList<>();
        for (int j = 2; j <= name.length(); j++) {
            for (int i = 0; i <= name.length() - j; i++) {
                cases.add(name.substring(i, j + i));
            }
        }
        return cases;
    }
    public static List<String> getName(List<List<String>> forms) {
        List<String> name = new ArrayList<>();
        for (List<String> form : forms) {
            name.add(form.get(1));
        }
        return name;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<String> names = getName(forms);
        List<List<String>> nameCase = new ArrayList<>();
        for (String name : names) {
            nameCase.add(getCase(name));
        }
        return answer;
    }
}
