package onboarding.domain.problem6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Info {
    private List<Nickname> names = new ArrayList<>();
    private List<String> emails = new ArrayList<>();


    public Info(List<List<String>> forms) {
        for (List<String> form : forms) {
            names.add(new Nickname(form.get(1)));
            emails.add(form.get(0));
        }
    }
    public List<String> overlapEmail() {
        List<String> overlapEmails = new ArrayList<>();
        for (int i=0; i < names.size(); i++) {
            for (int j=0; j < names.size(); j++) {
                if (names.get(i) != names.get(j) && names.get(i).hasOverlap(names.get(j))) {
                    overlapEmails.add(emails.get(i));
                }
            }
        }
        Collections.sort(overlapEmails);
        return overlapEmails.stream().distinct().collect(Collectors.toList());
    }

}
