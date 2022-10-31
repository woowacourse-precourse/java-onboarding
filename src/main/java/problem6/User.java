package problem6;

import java.util.*;

public class User {
    private final HashMap<String, String> forms;
    private final HashSet<String> emails;

    public User(List<List<String>> inputForms) {
        this.forms = initForm(inputForms);
        this.emails = new HashSet<>();
    }
    
    private HashMap<String, String> initForm(List<List<String>> inputForms) {
        HashMap<String, String> forms = new HashMap<>();
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
