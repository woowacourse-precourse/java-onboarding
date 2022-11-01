package onboarding.domain.problem6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * Problem number : 6
 * Comment : 유효하지 않은 신청폼 목록을 제공한다.
 * @author doyoung
 */
public class InvalidForms {
    private final Set<Form> invalidForms = new HashSet<>();
    
    public InvalidForms(List<Form> forms) {
        UsedTwoWordsDictionary dictionary = new UsedTwoWordsDictionary(forms);
        for (String twoWord : dictionary.getAllUsedTwoWords()) {
            List<Form> usingForms = dictionary.getFormsByTwoWords(twoWord);
            if (usingForms.size() > 1) {
                invalidForms.addAll(usingForms);
            }
        }
    }
    
    public List<String> getAllEmails() {
        List<String> emails = new ArrayList<>();
        for (Form form : invalidForms) {
            emails.add(form.getEmail());
        }
        return emails;
    }
}
