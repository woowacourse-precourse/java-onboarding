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

    /** 사용자 */
    public static class Member {
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

    /** 중복이름을 가진 사용자 저장소 */
    public static Set<Member> duplicateMemberList = new HashSet<>();
    /** 2글자로 잘린 이름 저장소 */
    public static Map<String, Member> nameStorage = new HashMap<>();

    public static List<String> solution(List<List<String>> forms) {
        List<Member> members = forms.stream()
                .map(form -> new Member(form.get(0), form.get(1)))
                .collect(Collectors.toList());

        for (Member member : members) {
            String name = member.getName();

            for (int i = 0; i < name.length() - 1; i++) {
                String slice = name.substring(i, i + 2);
                checkDuplicateName(slice, member);
            }
        }

        List<String> answer = duplicateMemberList.stream()
                .map(o -> o.email)
                .sorted()
                .collect(Collectors.toList());

        return answer;
    }

    /**
     * 유저 이름이 nameStorage에 존재한다면 duplicateUserEmail에 추가한다.
     * 이때 nameStorage에 존재하던 유저도 함께 추가한다.
     *
     * @param slice  : 잘라낸 이름
     * @param member : 사용자
     */
    private static void checkDuplicateName(String slice, Member member) {
        // 이제엠엠엠엠엠 같은 경우 한 멤버가 동일한 이름을 여럿 가질 경우를 고려해야함.
        if (nameStorage.containsKey(slice) && !member.name.equals(nameStorage.get(slice).getName())) {
            duplicateMemberList.add(member);
            duplicateMemberList.add(nameStorage.get(slice));
        } else {
            nameStorage.put(slice, member);
        }
    }
}
