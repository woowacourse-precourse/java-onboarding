package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import onboarding.domain.problem6.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        InvalidForms invalidForms = new InvalidForms(getFormList(forms));
        List<String> answer = invalidForms.getAllEmails();
        Collections.sort(answer);
        return answer;
    }

    private static List<Form> getFormList(List<List<String>> forms) {
        List<Form> result = new ArrayList<>();
        for (List<String> form : forms) {
            result.add(new Form(form.get(0), form.get(1)));
        }
        return result;
    }
}
