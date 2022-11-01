package problem6;

import java.util.List;
import java.util.Map;

public class CheckDto {
    private List<String> emails;
    private Map<String, Integer> count;
    private int index;

    public CheckDto(List<String> emails, Map<String, Integer> count, int index) {
        this.emails = emails;
        this.count = count;
        this.index = index;
    }

    public List<String> getEmails() {
        return emails;
    }

    public Map<String, Integer> getCount() {
        return count;
    }

    public int getIndex() {
        return index;
    }
}
