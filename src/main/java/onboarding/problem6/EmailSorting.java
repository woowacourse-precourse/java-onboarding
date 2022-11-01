package onboarding.problem6;

import java.util.Comparator;
import java.util.List;

public class EmailSorting {
    private final EmailListDto emails;

    public EmailSorting(EmailListDto unsorted) {
        sort(unsorted);
        this.emails = unsorted;
    }

    private void sort(EmailListDto unsorted) {
        unsorted.toList().sort(Comparator.naturalOrder());
    }

    public List<String> toList() {
        return emails.toList();
    }
}
