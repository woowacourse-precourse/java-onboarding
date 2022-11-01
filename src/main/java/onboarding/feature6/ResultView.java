package onboarding.feature6;

import static onboarding.feature6.Constants.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class ResultView {
    private List<String> results;

    public ResultView(UserInfo userInfo, DuplicateLettersFinder duplicateLettersFinder) {
        List<List<String>> forms = userInfo.getForms();
        Set<String> nicknamesWithDuplicateLetters = duplicateLettersFinder.getNicknamesWithDuplicateLetters();
        results = new ArrayList<>();

        for (String nickname : nicknamesWithDuplicateLetters) {
            updateResults(forms, nickname);
        }
    }

    public void updateResults(List<List<String>> forms, String nickname) {
        for (List<String> userData : forms) {
            if (userData.contains(nickname)) {
                results.add(userData.get(EMAIL_INDEX));
            }
        }
    }

    public List<String> getResults() {
        Collections.sort(results);
        return results;
    }
}
