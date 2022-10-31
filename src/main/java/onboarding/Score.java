package onboarding;

public class Score {
    private int score;

    public Score(){
        this.score = 0;
    }

    public int getScore(){
        return this.score;
    }

    public void addFriendScore(){
        this.score +=10;
    }

    public void addVisitorScore(){
        this.score +=1;
    }
}
