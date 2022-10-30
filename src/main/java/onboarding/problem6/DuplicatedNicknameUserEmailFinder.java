package onboarding.problem6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DuplicatedNicknameUserEmailFinder implements EmailFinder{


    public List<String> findDuplicatedNicknameUserEmail(List<List<String>> inputs) {
        List<String> emails = new ArrayList<>();
        storeEmail(inputs, emails);
        emails.sort(Comparator.naturalOrder());
        return emails;
    }

    private void storeEmail(List<List<String>> inputs, List<String> emails) {
        for(int i = 0; i < inputs.size() - 1; i++) {
            List<String> form = inputs.get(i);
            String email = form.get(0);
            String nickname = form.get(1);

            store(inputs, emails, i, email, nickname);
        }
    }

    private void store(List<List<String>> inputs, List<String> emails, int idx, String email,
        String nickname) {
        for(int j = idx +1; j < inputs.size(); j++) {
            List<String> comparisonForm = inputs.get(j);

            String comparisonEmail = comparisonForm.get(0);
            String comparisonNickname = comparisonForm.get(1);

            if(isNotComparableNickname(nickname)) {
                continue;
            }

            storeIfNicknameDuplicated(emails, email, nickname, comparisonEmail, comparisonNickname);
        }
    }

    private void storeIfNicknameDuplicated(List<String> emails, String email, String nickname,
        String comparisonEmail, String comparisonNickname) {
        if(isDuplicated(nickname, comparisonNickname)) {
            storeEmail(emails, email, comparisonEmail);
        }
    }

    private void storeEmail(List<String> emails, String email1, String email2) {
        if(hasNotEmails(emails, email1)) {
            emails.add(email1);
        }
        if(hasNotEmails(emails, email2)) {
            emails.add(email2);
        }
    }

    private boolean hasNotEmails(List<String> emails, String email) {
        return !emails.contains(email);
    }

    private boolean isNotComparableNickname(String nickname) {
        return nickname.length() < 2;
    }

    private boolean isDuplicated(String nickname1, String nickname2) {
        for(int i = 0; i < nickname1.length() - 1; i++) {
            if(hasSameContinuousParts(nickname1, nickname2, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasSameContinuousParts(String nickname1, String nickname2, int i) {
        return nickname2.contains(nickname1.substring(i, i + 2));
    }
}
