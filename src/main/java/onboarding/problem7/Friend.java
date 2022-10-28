package onboarding.problem7;

public class Friend implements Comparable<Friend> {

    private String name;
    private Integer score;

    private Friend() {
    }

    public Friend(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public Integer getScore() {
        return score;
    }


    @Override
    public int compareTo(Friend friend) {
        if (this.getScore().equals(friend.getScore())) {
            return this.getName().compareTo(friend.getName());  // 이름 순서
        }

        return friend.getScore() - this.getScore();
    }

    @Override
    public String toString() {
        return "[name=" + name + ", " + "score=" + score + "]";
    }
}
