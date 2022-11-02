package problem6;

import problem6.validator.ValidatorFactory;

import java.util.*;

public class Crew {
    private final Map<String, String> forms;
    private final Set<String> emails;

    public Crew(List<List<String>> inputForms) {
        this.forms = initForms(inputForms);
        this.emails = new HashSet<>();
        ValidatorFactory validatorFactory = new ValidatorFactory(forms);
        validatorFactory.validate(inputForms.size());
    }

    private Map<String, String> initForms(List<List<String>> inputForms) {
        Map<String, String> forms = new HashMap<>();
        for (List<String> form : inputForms) {
            String email = form.get(1);
            String name = form.get(0);
            forms.put(name, email);
        }
        return forms;
    }

    public List<String> findDuplicateUser() {
        for (Map.Entry<String, String> entry : forms.entrySet()) {
            checkDuplicateUser(entry);
        }
        return convertEmailsToListAndSort();
    }

    private void checkDuplicateUser(Map.Entry<String, String> entry) {
        String email = entry.getKey();
        String name = entry.getValue();
        for(int i = 0; i < name.length()-1; i++) {
            String subName = name.substring(i, i+2);
            getDuplicateUserEmails(email, subName);
        }
    }

    private void getDuplicateUserEmails(String targetEmail, String subName) {
        forms.keySet().stream()
                .filter(email -> !email.equals(targetEmail))
                .filter(email -> forms.get(email).contains(subName))
                .forEach(emails::add);
    }

    private List<String> convertEmailsToListAndSort() {
        List<String> result = new ArrayList<>(emails);
        Collections.sort(result);
        return result;
    }
}
