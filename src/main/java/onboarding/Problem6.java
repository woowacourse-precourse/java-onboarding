package onboarding;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 📚 기능 목록
 *
 * 1. 사용자의 이름을 두글자 씩 분리하는 기능
 * 2. 사용자의 이름 중복을 확인하는 기능
 * 3. 중복된 이름을 가진 사용자를 저장하는 기능
 * 4. 결과 목록을 정렬하는 기능
 */
public class Problem6 {

    private static class Member {
        private String name;
        private String email;
        private boolean duplicated = false;

        Member() {
        }

        Member(String email, String name) {
            this.email = email;
            this.name = name;
        }

        public String getEmail() {
            return this.email;
        }

        public String getName() {
            return this.name;
        }

        public boolean isDuplicated() {
            return this.duplicated;
        }

        public void setDuplicated() {
            this.duplicated = true;
        }
    }

    private static class Dictionary {
        private final Set<Member> duplicateMemberList = new HashSet<>();
        private final Map<String, Member> nameStorage = new HashMap<>();

        Dictionary() {
        }

        Dictionary(List<Member> members) {
            members.forEach(member -> {
                String name = member.getName();
                for (int i = 0; i < (name.length() - 1); i++) {
                    String slice = name.substring(i, i + 2);
                    nameStorage.put(slice, member);
                }
            });
        }

        public void checkAndSaveDuplicateMember(Member member) {
            String name = member.getName();

            for (int i = 0; i < (name.length() - 1); i++) {
                String slice = name.substring(i, i + 2);
                if (isDuplicateMember(member, slice)) {
                        saveDuplicateMember(member, slice);
                }
            }
        }

        public List<String> getDuplicationMemberAsResult() {
            return duplicateMemberList.stream()
                    .map(o -> o.email)
                    .sorted()
                    .collect(Collectors.toList());
        }

        private boolean isDuplicateMember(Member member, String slice) {
            return nameStorage.containsKey(slice) && !member.equals(nameStorage.get(slice));
        }

        private void saveDuplicateMember(Member member, String slice) {
            duplicateMemberList.add(member);
            duplicateMemberList.add(nameStorage.get(slice));
        }
    }

    public static List<String> solution(List<List<String>> forms) {
        List<Member> members = forms.stream()
                .map(form -> new Member(form.get(0), form.get(1)))
                .collect(Collectors.toList());

        Dictionary dictionary = new Dictionary(members);

        for (Member member : members) {
            dictionary.checkAndSaveDuplicateMember(member);
        }

        return dictionary.getDuplicationMemberAsResult();
    }
}
