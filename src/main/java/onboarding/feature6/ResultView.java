package onboarding.feature6;

import static onboarding.feature6.Constants.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class ResultView {
    private List<String> results;

    public ResultView(Set<String> nicknamesWithDuplicateLetters, List<List<String>> forms) {
        results = new ArrayList<>();
        for (String nickname : nicknamesWithDuplicateLetters) {
            for (List<String> userInfo : forms) {
                updateResults(userInfo, nickname);
            }
        }
    }

    public void updateResults(List<String> userInfo, String nickname) {
        if (userInfo.contains(nickname)) {
            results.add(userInfo.get(EMAIL_INDEX));
        }
    }

    public List<String> getResults() {
        Collections.sort(results);
        return results;
    }
}
