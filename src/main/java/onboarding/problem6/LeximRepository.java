package onboarding.problem6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class LeximRepository {
    private List<String> repository;

    LeximRepository() {
        repository = new ArrayList<>();
    }

    void addLexim(String lexim) {
        repository.add(lexim);
    }

    int countLexim(String lexim) {
        return Collections.frequency(repository, lexim);
    }
}
