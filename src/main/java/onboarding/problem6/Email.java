package onboarding.problem6;

public class Email implements Comparable<Email> {
    private final String name;

    public Email(final String email) {
        this.name  = email.split("@")[0];
    }

    @Override
    public int compareTo(Email o) {
        // 사전순으로 정렬 함
        return name.compareTo(o.name) ;
    }

    public String email() {
        return name + "@email.com";
    }
}
