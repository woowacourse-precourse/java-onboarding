package onboarding.problem6;

public class Crew {
    Name name;
    Email email;

    public Crew(Name name, Email email) {
        this.name = name;
        this.email = email;
    }

    public Name getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }
}
