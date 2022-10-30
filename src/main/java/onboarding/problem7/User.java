package onboarding.problem7;

public class User {
    private String name;

    public User(String name) throws Exception {
        if(name.length() < 1 || name.length() > 30) {
            throw new Exception("사용자의 이름은 1자이상 30자 이하여야 합니다");
        }
        if (!name.matches("^[a-z]*$")) {
            throw new Exception("사용자의 이름은 소문자로만 이뤄져야 합니다");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
