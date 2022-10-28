package onboarding.domain.problem6;

import java.util.ArrayList;
import java.util.List;

public class Info {
    private List<Nickname> names = new ArrayList<>();
    private List<Email> emails = new ArrayList<>();


    public Info(List<List<String>> forms) {
        for (List<String> form : forms) {
            names.add(new Nickname(form.get(1)));
            emails.add(new Email(form.get(0)));
        }

    }
}
