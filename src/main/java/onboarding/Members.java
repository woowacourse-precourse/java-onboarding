package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Members {
    private List<Member> members = new ArrayList<>();

    public void add(Member member) {
        members.add(member);
    }

    private String getEmailForName(String name) {
        return members.stream()
                .filter(member -> name.equals(member.getNickname()))
                .map(member -> member.getEmail())
                .collect(Collectors.joining());
    }

    private List<String> getEmailsForNames(List<String> names) {
        List<String> emails = new ArrayList<>();

        for (int i = 0; i < names.size(); i++)
            emails.add(getEmailForName(names.get(i)));

        return emails.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
