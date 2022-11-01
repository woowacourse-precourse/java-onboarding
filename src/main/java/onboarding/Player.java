package onboarding;

import java.util.List;

public class Player {
    private int score;

    private List<Integer> pages;

    public Player(List<Integer> pages){
        this.pages = pages;
    }

    public List<Integer> getPages() {
        return pages;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
