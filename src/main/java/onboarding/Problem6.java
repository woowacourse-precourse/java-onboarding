package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import domain.Form;
import domain.FormValidator;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        FormValidator validator = new FormValidator(getFormList(forms));
        for (Form form : validator.getInvalidForms()) {
            answer.add(form.getEmail());
        }
        Collections.sort(answer);
        return answer;
    }

    /**
     * 신청목록(forms)의 List<String> 객체를 vo객체 Form으로 바꾸어 반환한다.
     * @param forms
     * @return Form 타입의 ArrayList
     */
    private static List<Form> getFormList(List<List<String>> forms) {
        List<Form> result = new ArrayList<>();
        for (List<String> form : forms) {
            result.add(new Form(form.get(0), form.get(1)));
        }
        return result;
    }
}
