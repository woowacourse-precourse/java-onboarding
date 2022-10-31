package onboarding;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 📚 기능 목록
 * 1. 사용자 객체 - Member
 * 1-1. 이름과 이메일을 가진다.
 *
 * 2. 사전 객체 - Dictionary
 * 2-1. 중복된 사용자 List, 두글자로 slice한 이름 목록을 가진다. - dulplicateMamberList, nameStorage
 * 2-2. 사용자 List를 받아 초기화한다. - Dictionary(List&lt;Member&gt; member)
 * 2-3. 주어진 사용자의 이름 중복을 체크하고 저장한다. - checkAndSaveDuplicateMember
 * 2-4. 중복 사용자를 조건에 맞춰 결과 List로 반환한다. - getDuplicateMemberAsResult
 */
public class Problem6 {

    private static class Member {
        private String name;
        private String email;

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

        public List<String> getDuplicateMemberAsResult() {
            return duplicateMemberList.stream()
                    .map(Member::getEmail)
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

        return dictionary.getDuplicateMemberAsResult();
    }
}
