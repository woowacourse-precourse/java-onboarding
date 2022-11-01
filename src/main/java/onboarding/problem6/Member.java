package onboarding.problem6;

public class Member {

    private final int no;
    private final String email;
    private final String name;

    public Member(int no, String email, String name) {
        this.no = no;
        this.email = email;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

}
