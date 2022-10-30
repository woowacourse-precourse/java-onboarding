package onboarding.problem7;

public class FriendCandidate implements Comparable<FriendCandidate> {
    private String name;
    private int score;

    public FriendCandidate(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(FriendCandidate fc) {
        if(this.score == fc.getScore()) {
            return fc.getName().compareTo(this.name);
        }

        return this.score - fc.getScore();
    }
}
