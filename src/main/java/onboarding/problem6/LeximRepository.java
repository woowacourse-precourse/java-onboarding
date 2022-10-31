package onboarding.problem6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class LeximRepository {
    private List<String> repository;

    LeximRepository() {
        repository = new ArrayList<>();
    }

    void addLexim(List<String> lexims) {
        repository.addAll(lexims);
    }
    int countLexim(String lexim) {
        return Collections.frequency(repository, lexim);
    }

    public boolean isNameExistsInRepo(String name) {
        for (int j = 0; j < name.length()-1; j++) {
            if (countLexim(name.substring(j, j+2)) >= 2) {
                return true;
            }
        }
        return false;
    }
}
