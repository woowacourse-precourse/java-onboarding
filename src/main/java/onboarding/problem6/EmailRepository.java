package onboarding.problem6;


import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class EmailRepository {
    List<String> repository;

    EmailRepository() {
        repository = new ArrayList<>();
    }

    public void addEmail(List<String> email) {
        repository.addAll(email);
    }

    public void sort() {
        Collections.sort(repository);
    }

    public List<String> getDistinctEmails() {
        return Util.removeOverlap(repository);
    }

}
