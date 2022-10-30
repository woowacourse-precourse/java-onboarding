package onboarding.problem6;


import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class EmailRepository {
    List<String> repository;

    EmailRepository() {
        repository = new ArrayList<>();
    }

    void addEmail(String email) {
        repository.add(email);
    }

    void sort() {
        Collections.sort(repository);
    }

    List<String> getDistinctEmails() {
        return Util.removeOverlap(repository);
    }
}
