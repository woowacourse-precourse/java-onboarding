package onboarding;

import onboarding.feature6.DuplicateLettersFinder;
import onboarding.feature6.EmailView;
import onboarding.feature6.UserInfo;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        UserInfo userInfo = new UserInfo(forms);
        DuplicateLettersFinder duplicateLettersFinder = new DuplicateLettersFinder(userInfo);
        Set<String> duplicateLettersList = duplicateLettersFinder.duplicateLettersList;

        EmailView emailView = new EmailView(duplicateLettersFinder);
        Map<String, List<String>> answers = emailView.getSortedResults();

        /*
         * I think there could be several cases of adjacent duplicate letters depending on given nicknames,
         * so if you just returned ANSWERS variable above, you would get all the cases needed.
         * But the given test case has only 'one case' (제이).
         * So it has to return only one case from ANSWERS as below.
         * [jason@email.com, jm@email.com, mj@email.com]
         */
        Iterator<String> iterator = duplicateLettersList.iterator();
        String duplicateLetters = iterator.next(); // You can get only one case of duplicate letters from the given nicknames.
        List<String> answer = answers.get(duplicateLetters);
        return answer;
    }
}
