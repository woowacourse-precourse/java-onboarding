package onboarding.problem6;

import java.util.List;

public class EmailListDto {
    private final List<String> emails;

    public EmailListDto(List<String> emails) {
        this.emails = emails;
    }

    public List<String> toList() {
        return emails;
    }
}
