package onboarding.problem6;

import java.util.*;

public class Users {

    private List<User> users = new ArrayList<>();
    private final Set<String> emails = new TreeSet<>();
    private final Map<String, String> crewWords = new HashMap<>();

    public Users(List<List<String>> forms) {
        List<User> users = new ArrayList<>();
        for (List<String> form : forms) {
            users.add(new User(form.get(0), form.get(1)));
        }
        this.users = users;
    }

    public Set<String> getEmailOfDuplicateName() {
        for (User user : users) {
            List<String> userWords = user.getWords();
            checkDuplicateName(user, userWords);
        }
        return emails;
    }

    private void checkDuplicateName(User user, List<String> userWords) {
        for (String userWord : userWords) {
            if (crewWords.containsKey(userWord)) {
                String email = crewWords.get(userWord);
                addEmail(user, email);
            }
            crewWords.put(userWord, user.getEmail());
        }
    }

    private void addEmail(User user, String email) {
        if (!email.equals(user.getEmail())) {
            emails.add(email);
            emails.add(user.getEmail());
        }
    }
}

