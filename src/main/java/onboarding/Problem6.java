package onboarding;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static HashSet<String> duplicateEmail;
    public static HashMap<String,String> subsetInfo;
    public static List<String> checkDuplicateName(List<List<String>> forms) {
        duplicateEmail = new HashSet<>();
        subsetInfo = new HashMap<>();

        for(int index = 0; index < forms.size(); index ++) {
            String email = forms.get(index).get(0);
            String name = forms.get(index).get(1);

            inputDuplicateName(name,email);
        }

        List<String> answer = duplicateEmail.stream()
                .sorted()
                .collect(Collectors.toList());
        return answer;
    }
    public static void inputDuplicateName(String name, String email) {

    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = checkDuplicateName(forms);
        return answer;
    }
}
