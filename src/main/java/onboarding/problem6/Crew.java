package onboarding.problem6;

public class Crew implements Comparable<Crew> {

    private final String email;
    private final String nickname;

    private boolean isOverlap = false;

    public Crew(String email, String nickname) {
        this.email = email;
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }

    public boolean isOverlap() {
        return isOverlap;
    }

    public void overlap() {
        this.isOverlap = true;
    }

    @Override
    public int compareTo(Crew c) {
        return this.getEmail().compareTo(c.getEmail());
    }
}
