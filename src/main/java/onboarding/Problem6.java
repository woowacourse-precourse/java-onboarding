package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static void subStrName(String name, List<String> cases, int length) {
        for (int i = 0; i <= name.length() - length; i++) {
            cases.add(name.substring(i, i + length));
        }
    }
    public static List<String> getCase(String name) {
        List<String> cases = new ArrayList<>();
        for (int length = 2; length <= name.length(); length++) {
            subStrName(name, cases, length);
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
        List<List<String>> nameCases = new ArrayList<>();
        for (String name : names)
            nameCases.add(getCase(name));
        for (List<String> nameCase : nameCases) {
            for (String name : nameCase) {

            }
        }
        return answer;
    }
}
