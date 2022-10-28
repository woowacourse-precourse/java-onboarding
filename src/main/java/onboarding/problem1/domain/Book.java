package onboarding.problem1.domain;

import java.util.Random;

public class Book {
    private int leftPage;
    private int rightPage;
    private int lastScore;
    private int leftPageScore;
    private int rightPageScore;

    public int openBook() {
        return new Random().nextInt(400) + 1;
    }

    public boolean isEvenPage(int page) {
        return (page % 2 == 0);
    }

    public void setPage(int page) {
        if (isEvenPage(page)) {
            leftPage = page - 1;
            rightPage = page;
            return;
        }
        leftPage = page;
        rightPage = page + 1;
    }

    public void setPageScore(int page) {
    }

    public void setLastScore() {
    }

    public int getLastScore() {
        return lastScore;
    }

    public int getLeftPage() {
        return leftPage;
    }

    public int getRightPage() {
        return rightPage;
    }

    public int getLeftPageScore() {
        return leftPageScore;
    }

    public int getRightPageScore() {
        return rightPageScore;
    }
}
