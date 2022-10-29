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

    // comment : 변수 명은 List인데 자료형은 Set?
    // comment : 같은 Collection을 상속받으니 List로 명명해도 무관한거 아닌가?
    public static Set<Member> duplicateMemberList = new HashSet<>();
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
    // comment : checkDuplicateName 함수명은 중복된 이름 체크만을 수행한다고 명시되어있지만 nameStorage에 저장하는 부수행위를 수행한다.
    // comment : 하나의 함수는 하나의 기능만 가져아한다. 부수행위는 존재하면 안된다.
    private static void checkDuplicateName(String slice, Member member) {
        if (nameStorage.containsKey(slice) && !member.name.equals(nameStorage.get(slice).getName())) {
            duplicateMemberList.add(member);
            duplicateMemberList.add(nameStorage.get(slice));
        } else {
            nameStorage.put(slice, member);
        }
    }
}
