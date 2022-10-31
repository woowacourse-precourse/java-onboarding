package onboarding.problem6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Deduplication {
    private final Set<String> set;

    public Deduplication() {
        this.set = new HashSet<>();
    }

    public void add(String email) {
        set.add(email);
    }

    public EmailListDto getRemoved() {
        return new EmailListDto(new ArrayList<>(set));
    }

}
