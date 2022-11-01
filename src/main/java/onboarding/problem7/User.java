package onboarding.problem7;

public class User {
    private String name;

    public User(String name) {
        if(name.length() < 1 || name.length() > 30) {
            System.out.println("사용자의 이름은 1자이상 30자 이하여야 합니다");
        }
        if (!name.matches("^[a-z]*$")) {
            System.out.println("사용자의 이름은 소문자로만 이뤄져야 합니다");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
