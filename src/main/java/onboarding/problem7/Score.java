package onboarding.problem7;

public class Score implements Comparable<Score> {
    private final String userName;
    private int score;

    public Score(String userName) {
        this.userName = userName;
        this.score = 0;
    }

    public Score add(int i) {
        this.score += i;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public int getScore() {
        return score;
    }

    //Sort는 compareTo가 작은거부터(오름차순)
    @Override
    public int compareTo(Score o) {
        if (this.score > o.getScore()) {
            return 1;
        } else if(this.score < o.getScore()) {
            return -1;
        }
        return -this.userName.compareTo(o.getUserName());
    }
}
