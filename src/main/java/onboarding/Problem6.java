package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        int size = forms.size();

        if (size <= 1) {
            return new ArrayList<>();
        }

        List<Member> memberRepository = new ArrayList<>();
        Set<String> emailHashSet = new HashSet<>();

        for (List<String> form : forms) {

            if (memberRepository.size() == 0) {
                memberRepository.add(new Member(form.get(1), form.get(0)));
                continue;
            }

            for (Member member : memberRepository) {
                if (hasConsecutiveString(form.get(1), member.name)) {
                    emailHashSet.add(form.get(0));
                    emailHashSet.add(member.email);
                }
            }
            memberRepository.add(new Member(form.get(1), form.get(0)));
        }

        return emailHashSet.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    static class Member {
        private String name;
        private String email;

        public Member(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }

    private static boolean hasConsecutiveString(String base, String target) {

        int baseLength = base.length();
        int targetLength = target.length();

        for (int i = 0; i < baseLength - 1; i++) {
            for (int j = 0; j < targetLength - 1; j++) {
                if (base.charAt(i) == target.charAt(j)) {
                    if (base.charAt(i + 1) == target.charAt(j + 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
