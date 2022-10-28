package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Members {
    private List<Member> members = new ArrayList<>();

    public void add(Member member) {
        members.add(member);
    }

    public List<String> emailsForDuplicateMembers() {
        String str;
        List<String> duplicateMembers = new ArrayList<>();
        List<String> names = members.stream()
                .map(member -> member.getNickname())
                .collect(Collectors.toList());

        for (int i = 0; i < names.size(); i++) {
            str = names.get(i);
            duplicateMembers.addAll(duplicateNames(names, str, i));
        }

        return getEmailsForNames(duplicateMembers.stream()
                .distinct()
                .collect(Collectors.toList()));
    }


    private List<String> duplicateNames(List<String> names, String str, int index) {
        List<String> duplicateNames = new ArrayList<>();

        for (int i = 0; i < str.length() - 1; i++) {
            String subStr = str.substring(i, i + 2);

            duplicateNames.addAll(names.stream()
                    .filter(s -> !s.equals(names.get(index)))
                    .filter(s -> s.contains(subStr))
                    .collect(Collectors.toList()));
        }

        return duplicateNames;
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
