package onboarding.problem6;

import java.util.List;

public class User {
    private String email;
    private String name;

    public User(List<String> data) {
        this.email = data.get(0);
        this.name = data.get(1);
    }

    public String getEmail() {
        return email;
    }

    public boolean checkDuplicated(User user1) {
    }
//User입력받고 name 중복 부분 비교 후 boolean 반환하는 함수

    //중복 부분 비교 시 사용할 조건 함수
}
