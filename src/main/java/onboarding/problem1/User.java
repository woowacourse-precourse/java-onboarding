package onboarding.problem1;

public class User {
    public String userName;
    public Integer leftPage;
    public Integer rightPage;
    public Integer score;

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getUserName() {
        return userName;
    }

    public Integer getLeftPage() {
        return leftPage;
    }

    public Integer getRightPage() {
        return rightPage;
    }

    public Integer getScore() {
        return score;
    }

    public User(String userName, Integer leftPage, Integer rightPage, Integer score) {
        this.userName = userName;
        this.leftPage = leftPage;
        this.rightPage = rightPage;
        this.score = score;
    }
}
