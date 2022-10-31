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
}
