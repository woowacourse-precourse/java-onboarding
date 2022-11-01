package onboarding.feature6;

import static onboarding.feature6.Constants.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateLettersFinder {
    private List<String> nicknames;
    private Set<String> nicknamesWithDuplicateLetters;

    public DuplicateLettersFinder(List<String> nicknames) {
        this.nicknames = nicknames;
    }

    public Set<String> getNicknamesWithDuplicateLetters() {
        nicknamesWithDuplicateLetters = new HashSet<>();
        for (int i = 0; i < nicknames.size() - 1; i++) {
            String currentNickname = nicknames.get(i);
            for (int j = i + 1; j < nicknames.size(); j++) {
                String nextNickname = nicknames.get(j);
                compareNicknames(currentNickname, nextNickname);
            }
        }
        return nicknamesWithDuplicateLetters;
    }

    public void compareNicknames(String currentNickname, String nextNickname) {
        for (int i = 0; i < currentNickname.length() - 1; i++) {
            String lettersOfCurrentNickname = currentNickname.substring(i, i + INCREMENT);
            checkExistenceOfLetters(currentNickname, nextNickname, lettersOfCurrentNickname);
        }
    }

    public void checkExistenceOfLetters(String currentNickname, String nextNickname, String lettersOfCurrentNickname) {
        if (nextNickname.contains(lettersOfCurrentNickname)) {
            nicknamesWithDuplicateLetters.add(currentNickname);
            nicknamesWithDuplicateLetters.add(nextNickname);
        }
    }
}
