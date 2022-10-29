package onboarding.problem1.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Book {

    private int leftPage;
    private int rightPage;

    public Book() {
    }

    public Book(int leftPage, int rightPage) {
        this.leftPage = leftPage;
        this.rightPage = rightPage;
    }

    public boolean isEvenPage(int page) {
        return (page % 2 == 0);
    }

    public List<Integer> openBook() {
        int page = new Random().nextInt(400) + 1;
        setLeftRightPage(page);
        return Arrays.asList(leftPage, rightPage);
    }

    private void setLeftRightPage(int page) {
        if (isEvenPage(page)) {
            leftPage = page - 1;
            rightPage = page;
            return;
        }
        leftPage = page;
        rightPage = page + 1;
    }

    public int getLastScore() {
        List<Integer> LeftRightPageScoreList = getLeftRightPageScore();
        int lastScore = Math.max(LeftRightPageScoreList.get(0), LeftRightPageScoreList.get(1));
        return lastScore;
    }

    private List<Integer> getLeftRightPageScore() {
        int leftPageScore = getPageScore(leftPage);
        int rightPageScore = getPageScore(rightPage);
        return Arrays.asList(leftPageScore, rightPageScore);
    }

    private int getPageScore(int page) {
        int addScore = 0;
        int multiplyScore = 1;
        String[] PageDigits = String.valueOf(page).split("");
        for (String pageDigit : PageDigits) {
            addScore += Integer.parseInt(pageDigit);
            multiplyScore *= Integer.parseInt(pageDigit);
        }
        int score = Math.max(addScore, multiplyScore);
        return score;
    }
}