package onboarding.problem7;

public class User {
    private String username;

    public User(String username) throws Exception {
        if(username.length() < 1 || username.length() > 30) {
            throw new Exception("사용자의 이름은 1자이상 30자 이하여야 합니다");
        }
        this.username = username;
    }
}
