package onboarding;

import onboarding.feature6.DuplicateLettersFinder;
import onboarding.feature6.ResultView;
import onboarding.feature6.UserInfo;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        UserInfo userInfo = new UserInfo(forms);
        List<String> userNicknames = userInfo.getNicknames();

        DuplicateLettersFinder duplicateLettersFinder = new DuplicateLettersFinder(userNicknames);
        Set<String> nicknamesWithDuplicateLetters = duplicateLettersFinder.getNicknamesWithDuplicateLetters();

        ResultView resultView = new ResultView(nicknamesWithDuplicateLetters, forms);
        List<String> results = resultView.getResults();
        return results;
    }
}
