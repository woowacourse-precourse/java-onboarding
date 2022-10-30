package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 구현순서
 * 1. User class 구현 (email, name, dup, ...)
 * 2. forms를 User List로 변환
 * 3. 모든 User에 대해 dup 체크하는 메소드 작성
 * 4. User의 dup property가 true일 경우 set에 담아서 중복 제거
 * 5. Set을 List로 변환 후 오름차순 sorting
 */
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> emailSet = new HashSet<>();

        // form -> User 로 변환
        List<User> users = forms.stream().map(
                form -> new User(form.get(0), form.get(1)))
                .collect(Collectors.toList());
        // 중복 name을 가진 user 표시
        markDup(users);

        // 중복 name을 가진 user의 email을 set에 담아 중복 제거
        users.stream().forEach(user -> {
            if (user.isDup())
                emailSet.add(user.getEmail());
        });

        // set을 list로 변환 후, 오름차순 정렬
        List<String> answer = new ArrayList<>(emailSet);
        answer.sort(Comparator.naturalOrder());

        return answer;
    }

    /**
     * User List 내에 name 중복 여부를 표시한다.
     * 
     * @param users
     */
    private static void markDup(List<User> users) {
        for (int i = 0; i < users.size(); i++) {
            User iUser = users.get(i);
            if (iUser.isDup())
                continue;
            for (int j = i + 1; j < users.size(); j++) {
                User jUser = users.get(j);
                if (iUser.dupNameCheck(jUser)) {
                    iUser.setDup(true);
                    jUser.setDup(true);
                }
            }
        }
    }

}

class User {
    private String email;
    private String name;
    private Boolean dup = false;

    User(String email, String name) {
        this.email = email;
        this.name = name;
    }

    /**
     * this.name과target.name의 중복 여부를 확인한다.
     * 
     * @param target
     * @return 중복이면 true, 아니면 false
     */
    public Boolean dupNameCheck(User target) {
        for (int i = 0; i < this.name.length() - 1; i++) {
            String letters = this.name.substring(i, i + 2);
            if (target.getName().contains(letters)) {
                return true;
            }
        }
        return false;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public Boolean isDup() {
        return dup;
    }

    public void setDup(Boolean dup) {
        this.dup = dup;
    }
}