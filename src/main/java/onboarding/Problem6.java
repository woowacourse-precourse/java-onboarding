package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<Member> members = initialize(forms);

        Set<String> restrictedEmail = getRestrictedEmail(members);

        return restrictedEmail.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private static Set<String> getRestrictedEmail(List<Member> members) {
        Set<String> restrictedEmail = new HashSet<>();
        Member member;
        Member comparisonMember;
        for(int i = 0; i < members.size(); i++) {
            member = members.get(i);
            for(int j = i + 1; j < members.size(); j++) {
                comparisonMember = members.get(j);
                if(isDuplicated(member, comparisonMember)) {
                    restrictedEmail.add(member.getEmail());
                    restrictedEmail.add(comparisonMember.getEmail());
                    break;
                }
            }
        }

        return restrictedEmail;
    }

    private static boolean isDuplicated(Member member, Member comparisonMember) {
        String nickname = member.getNickname();
        String partNickname;

        for(int i = 0; i < nickname.length() - 1; i++) {
            partNickname = nickname.substring(i, i + 2);
            if(comparisonMember.getNickname().contains(partNickname)) {
                return true;
            }
        }

        return false;
    }

    private static List<Member> initialize(List<List<String>> forms) {
        List<Member> members = new ArrayList<>();
        String email;
        String nickname;

        for(List<String> person : forms) {
            email = person.get(0);
            nickname = person.get(1);

            members.add(new Member(email, nickname));
        }

        return members;
    }

    private static class Member {
        private final String email;
        private final String nickname;

        public Member(String email, String nickname) {
            isValidEmail(email);
            isValidNickname(nickname);
            this.email = email;
            this.nickname = nickname;
        }

        public String getEmail() {
            return this.email;
        }

        public String getNickname() {
            return this.nickname;
        }

        private void isValidEmail(String email) {
            int length = email.length();
            if(length < 11 || 20 < length) {
                throw new IllegalArgumentException("이메일의 길이가 적절하지 않습니다.");
            }
            if(!email.endsWith("@email.com")) {
                throw new IllegalArgumentException("이메일의 형식이 적합하지 않습니다.");
            }
        }

        private void isValidNickname(String nickname) {
            int length = nickname.length();
            if(length < 1 || 20 < length) {
                throw new IllegalArgumentException("닉네임의 길이가 적절하지 않습니다.");
            }
        }
    }
}
