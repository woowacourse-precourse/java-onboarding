package onboarding;

import java.util.List;

class Gamer implements Comparable<Gamer> {
    private Page leftPage, rightPage;
    private int score;

    private Gamer() {}

    public Gamer(List<Integer> gamer) throws IllegalArgumentException {
        validatePages(gamer);

        leftPage = new Page(gamer.get(0));
        rightPage = new Page(gamer.get(1));
    }

    private void validatePages(List<Integer> gamer) throws IllegalArgumentException {
        if (gamer.size() != 2) {
            throw new IllegalArgumentException("올바른 페이지 개수는 2개입니다.");
        }

        Page tmpLeftPage = new Page(gamer.get(0));
        Page tmpRightPage = new Page(gamer.get(1));

        if (tmpLeftPage.isPageEven() || !tmpRightPage.isPageEven()) {
            throw new IllegalArgumentException("왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수여야 합니다.");
        }

        if (!tmpLeftPage.isConsecutivePageWith(tmpRightPage)) {
            throw new IllegalArgumentException("연속된 페이지를 입력해주세요.");
        }
    }

    public void calcPersonalScore() {
        score = Math.max(leftPage.getPageMaxScore(), rightPage.getPageMaxScore());
    }

    @Override
    public int compareTo(Gamer o) {
        return Integer.compare(this.score, o.score);
    }
}

class Page {
    private int pageNumber;

    private Page() {}

    public Page(int pageNumber) throws IllegalArgumentException {
        if (!isAvailPageRange(pageNumber)) {
            throw new IllegalArgumentException("올바른 범위의 페이지를 입력해주세요.");
        }
        this.pageNumber = pageNumber;
    }

    public int getPageMaxScore() {
        int addSum = 0;
        int multSum = 1;

        for (byte b : String.valueOf(pageNumber).getBytes()) {
            int number = Character.getNumericValue(b);
            addSum += number;
            multSum *= number;
        }

        return Math.max(addSum, multSum);
    }

    public boolean isPageEven() {
        return pageNumber % 2 == 0;
    }

    public boolean isConsecutivePageWith(Page anotherPage) {
        return Math.abs(this.pageNumber - anotherPage.pageNumber) == 1;
    }

    private static boolean isAvailPageRange(int page) {
        return page >= 0 && page <= 400;
    }
}

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Gamer gamerPobi;
        Gamer gamerCrong;

        try {
            gamerPobi = new Gamer(pobi);
            gamerCrong = new Gamer(crong);
        } catch (IllegalArgumentException e) {
            return -1;
        }

        gamerPobi.calcPersonalScore();
        gamerCrong.calcPersonalScore();

        return gamerPobi.compareTo(gamerCrong);
    }
}
