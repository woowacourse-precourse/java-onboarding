package onboarding.domain.problem6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InvalidForms {
    private final Set<Form> invalidForms = new HashSet<>();
    
    public InvalidForms(UsedTwoWordsDictionary dictionary) {
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
