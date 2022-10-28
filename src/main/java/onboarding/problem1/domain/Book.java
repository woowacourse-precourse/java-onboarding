package onboarding.problem1.domain;

import java.util.Random;

public class Book {

    private int leftPage;
    private int rightPage;
    private int lastScore;
    private int leftPageScore;
    private int rightPageScore;

    public Book() {
    }

    public Book(int leftPage, int rightPage) {
        this.leftPage = leftPage;
        this.rightPage = rightPage;
    }

    public int openBook() {
        return new Random().nextInt(400) + 1;
    }

    public boolean isEvenPage(int page) {
        return (page % 2 == 0);
    }

    public void setLeftRightPage(int page) {
        if (isEvenPage(page)) {
            leftPage = page - 1;
            rightPage = page;
            return;
        }
        leftPage = page;
        rightPage = page + 1;
    }

    public void setLeftRightPageScore(Book book) {
        setPageScore(book.getLeftPage());
        setPageScore(book.getRightPage());
    }

    private void setPageScore(int page) {
        int addScore = 0;
        int multiplyScore = 1;
        String[] PageDigits = String.valueOf(page).split("");
        for (String pageDigit : PageDigits) {
            addScore += Integer.parseInt(pageDigit);
            multiplyScore *= Integer.parseInt(pageDigit);
        }
        int score = Math.max(addScore, multiplyScore);
        if (isEvenPage(page)) {
            rightPageScore = score;
            return;
        }
        leftPageScore = score;
    }

    public void setLastScore(Book book) {
        lastScore = Math.max(book.getLeftPageScore(), book.getRightPageScore());
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