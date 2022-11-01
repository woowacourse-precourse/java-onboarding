package onboarding.problem6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Selector {

    private final Crew crew;

    public Selector(List<List<String>> forms) {
        this.crew = new Crew(forms);
    }

    public List<String> findEmailsWithDuplicatedName() {
        List<String> notifiedEmails = new ArrayList<>();

        for (int size = crew.size(), i = 0; i < size; i++) {
            Member targetMember = this.crew.get(i);
            notifiedEmails.addAll(findEmailsWithTargetMember(targetMember));
        }

        return notifiedEmails.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    private List<String> findEmailsWithTargetMember(Member targetMember) {
        List<String> notifiedEmails = new ArrayList<>();
        String currentEmail = targetMember.getEmail();
        String currentName = targetMember.getName();

        for (int len = currentName.length() - 1, i = 0; i < len; i++) {
            String targetName = currentName.substring(i, i + 2);
            notifiedEmails.addAll(findEmailsWithTargetName(targetMember, targetName));
        }

        if (!notifiedEmails.isEmpty()) {
            notifiedEmails.add(currentEmail);
        }

        return notifiedEmails;
    }

    private List<String> findEmailsWithTargetName(Member targetMember, String targetName) {
        List<String> notifiedEmails = new ArrayList<>();

        List<Member> afterMembers = crew.getAfter(targetMember);
        for (Member member : afterMembers) {
            String name = member.getName();

            if (RabinKarp.contains(name, targetName)) {
                String email = member.getEmail();
                notifiedEmails.add(email);
            }
        }

        return notifiedEmails;
    }

}
